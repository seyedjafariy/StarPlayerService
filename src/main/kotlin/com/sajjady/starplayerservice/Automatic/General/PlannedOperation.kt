package com.sajjady.starplayerservice.Automatic.General

import com.sajjady.starplayerservice.Automatic.WebPageNavigation.PageNavigator

public class PlannedOperation : IPlannedOperation {

    override var operationIsStressful: Boolean = false

    override fun startOperation() {
        val pageNavigator: IPageNavigator = PageNavigator()
        pageNavigator.start()
        pageNavigator.doAfterNavi = object : IDoAfterNavigating {
            override fun doAfterNavigate(): Boolean {
                return true
            }
        }
        pageNavigator.doWhenFinish = object : IDoAfterFinish {
            override fun doAfterFinish() {

            }
        }

    }

}