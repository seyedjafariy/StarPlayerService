package com.sajjady.starplayerservice.Automatic.WebPageNavigation

data class PageEntity(
        override val pageNumber: Int,
        override val pageString: String)
    : IPageEntity