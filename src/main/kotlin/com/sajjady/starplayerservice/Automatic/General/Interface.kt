package com.sajjady.starplayerservice.Automatic.General

import com.sajjady.starplayerservice.Common.Model.BrowsingCapabilities
import com.sajjady.starplayerservice.Common.Model.MusicBrowsingSpecs
import com.sajjady.starplayerservice.Common.Model.WebPageModel

public interface IReadPage {
    public fun readPage(page: String, number: Int): MutableList<MusicBrowsingSpecs>
}

public interface IDoAfterNavigating {
    fun doAfterNavigate(t: WebPageModel): Boolean
}

public interface IDoAfterFinish {
    fun doAfterFinish()
}

public interface IPageNavigator {
    var doAfterNavi: IDoAfterNavigating?
    var doWhenFinish: IDoAfterFinish?
    fun start()
}

public interface IPlannedOperation {
    var operationIsStressful: Boolean
    public fun startOperation()
}

public interface IInsertPlannedEntity {
    public fun insertPlannedEntity()
}

interface IReadLinks {
    public fun readLinks(page: String, number: Int): MutableList<MusicBrowsingSpecs>
}