package com.sajjady.starplayerservice.Automatic.WebPageNavigation

import com.sajjady.starplayerservice.Automatic.General.IDoAfterFinish
import com.sajjady.starplayerservice.Automatic.General.IDoAfterNavigating
import com.sajjady.starplayerservice.Automatic.General.IPageNavigator
import com.sajjady.starplayerservice.Common.DatabaseOperation.ReadPages.GetLastPageEntityInfo
import com.sajjady.starplayerservice.Common.DatabaseOperation.ReadPages.IGetLastPageEntityInfo
import com.sajjady.starplayerservice.Common.Model.WebPageModel
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink

class PageNavigator : IPageNavigator {
    override var doAfterNavi: IDoAfterNavigating? = null
    override var doWhenFinish: IDoAfterFinish? = null

    override fun start() {
        val flux = Flux.create<WebPageModel> { fs: FluxSink<WebPageModel>? ->
            var pageNumber = 0
            fs!!.onRequest {
                val reqPageNumber = "page-${++pageNumber}"
                val lastPageEntity: IGetLastPageEntityInfo = GetLastPageEntityInfo()
                lastPageEntity.getLastPageEntityInfo(reqPageNumber).whenCompleteAsync { t, u ->
                    fs.next(WebPageModel(contents = t.body.toString(),
                            pageNumber = pageNumber,
                            place = "browse",
                            website = "mrTehran"
                    ))
                }
            }.onCancel {
                fs.complete()
            }
        }

        flux.subscribeWith(object : Subscriber<WebPageModel> {
            lateinit var subscription: Subscription

            override fun onComplete() {
                doWhenFinish!!.doAfterFinish()
            }

            override fun onSubscribe(s: Subscription?) {
                subscription = s!!
                s.request(1)
            }

            override fun onNext(t: WebPageModel) {
                println("next is emitted")
                if (doAfterNavi!!.doAfterNavigate(t)) {
                    subscription.request(1)
                    println("is executed in onnext")
                } else
                    subscription.cancel()
            }

            override fun onError(t: Throwable?) {
                subscription.cancel()
            }

        })
        flux.subscribe()

    }


}