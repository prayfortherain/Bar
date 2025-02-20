package com.example.bar

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId
import io.realm.kotlin.types.EmbeddedRealmObject

class Notes: RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId()

    var name: String = ""
    var description: String = ""
}

class Ingredient: RealmObject{
    @PrimaryKey
    var id: ObjectId = ObjectId()

    var name: String = ""
    var taste: String = ""
    var degree: String = ""
    var base: String = ""
    //var mixwith: RealmList<Ingredient> = realmListOf()
}

class Cocktail: RealmObject{
    @PrimaryKey
    var id: ObjectId = ObjectId()

    var name: String = ""
    //var ingredients: RealmList<Ingredient> = realmListOf()
    var instructions: String = ""
    var taste: String = ""
    var base : String = ""
    var group: String = ""
    var color : String = ""
}
