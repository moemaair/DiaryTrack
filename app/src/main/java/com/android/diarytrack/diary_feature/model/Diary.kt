package com.android.diarytrack.diary_feature.model
//
//import androidx.room.PrimaryKey
//import com.android.diarytrack.diary_feature.model.Mood
//import io.realm.kotlin.ext.realmListOf
//import io.realm.kotlin.types.ObjectId
//import io.realm.kotlin.types.RealmInstant
//import io.realm.kotlin.types.RealmList
//import io.realm.kotlin.types.RealmObject
//
//class Diary :RealmObject{
//
//    @PrimaryKey
//    var id: ObjectId = ObjectId.create()
//    var ownerId: String = ""
//    var mood: String = Mood.Neutral.name
//    var title: String = ""
//    var description: String = ""
//    var images: RealmList<String> = realmListOf()
//    var date: RealmInstant = RealmInstant.from(System.currentTimeMillis(),0)
//}