package com.sajjady.starplayerservice.Automatic.General

public interface IReadPage {
    public fun readPage(page: String)
}

public interface IDoAfterNavigating {
    fun doAfterNavigate(): Boolean
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