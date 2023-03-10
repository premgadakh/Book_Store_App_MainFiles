package com.example.bookapp

import com.google.gson.JsonObject

class DataBook {
    var title: String? = null
    var isbn: String? = null
    var pageCount = 0
    var publishedDate: JsonObject? = null
    var thumbnailUrl: String? = null
    var shortDescription: String? = null
    var longDescription: String? = null
    var status: String? = null
    var authors: ArrayList<String>? = null
    var categories: ArrayList<String>? = null

    constructor() {}
    constructor(
        title: String?,
        isbn: String?,
        pageCount: Int,
        publishedDate: JsonObject?,
        thumbnailUrl: String?,
        shortDescription: String?,
        longDescription: String?,
        status: String?,
        authors: ArrayList<String>?,
        categories: ArrayList<String>?
    ) {
        this.title = title
        this.isbn = isbn
        this.pageCount = pageCount
        this.publishedDate = publishedDate
        this.thumbnailUrl = thumbnailUrl
        this.shortDescription = shortDescription
        this.longDescription = longDescription
        this.status = status
        this.authors = authors
        this.categories = categories
    }
}