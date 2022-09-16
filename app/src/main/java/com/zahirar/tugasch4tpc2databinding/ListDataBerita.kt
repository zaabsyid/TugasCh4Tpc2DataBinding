package com.zahirar.tugasch4tpc2databinding

import java.io.Serializable

data class ListDataBerita(var title : String, var date : String, var writer : String, var content : String, var image : Int ) : Serializable {
}