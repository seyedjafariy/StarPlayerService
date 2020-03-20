package com.sajjady.starplayerservice.Automatic.WebPageNavigation

import com.sajjady.starplayerservice.Automatic.General.IDoAfterFinish
import com.sajjady.starplayerservice.Automatic.General.IDoAfterNavigating
import com.sajjady.starplayerservice.Automatic.General.IPageNavigator
import com.sajjady.starplayerservice.Common.Controller.DatabaseOperation.ReadPages.GetLastPageEntityInfo
import com.sajjady.starplayerservice.Common.Controller.DatabaseOperation.ReadPages.IGetLastPageEntityInfo
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink

class PageNavigator : IPageNavigator {
    override var doAfterNavi: IDoAfterNavigating? = null
    override var doWhenFinish: IDoAfterFinish? = null

    override fun start() {
        val flux = Flux.create<String> { fs: FluxSink<String>? ->
            var pageNumber = 0
            fs!!.onRequest {
                val reqPageNumber = (++pageNumber).toString()
                val lastPageEntity: IGetLastPageEntityInfo = GetLastPageEntityInfo()
                lastPageEntity.getLastPageEntityInfo(reqPageNumber).whenCompleteAsync { t, u ->
                    fs.next(t.body.toString())
                }
            }.onCancel {
                fs.complete()
            }
        }

        flux.subscribeWith(object : Subscriber<String> {
            lateinit var subscription: Subscription

            override fun onComplete() {
                doWhenFinish!!.doAfterFinish()
            }

            override fun onSubscribe(s: Subscription?) {
                subscription = s!!
                s.request(1)
            }

            override fun onNext(t: String?) {
                println("next is emitted")
                if (doAfterNavi!!.doAfterNavigate())
                    subscription.request(1)
                else
                    subscription.cancel()
            }

            override fun onError(t: Throwable?) {
                subscription.cancel()
            }

        })
        flux.subscribe()

    }


}