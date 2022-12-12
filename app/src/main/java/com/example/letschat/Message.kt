package com.example.letschat

class Message {

    var message: String? = null
    var StringId: String? = null

    constructor(){}

    constructor(message: String?, StringId: String?)
    {
        this.message=message
        this.StringId=StringId
    }
}