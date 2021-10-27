package com.example.net.net.protocol

data class BaseRepoEntity<T>(
    var code : Int,
    var data : T,
    var msg : String
)