package com.dewarder.akommons.binding.common.string

interface TestableString {

    val stringRequiredExist: String
    val stringRequiredAbsent: String
    val stringOptionalExist: String?
    val stringOptionalAbsent: String?

    val stringsRequiredExist: List<String>
    val stringsRequiredAbsent: List<String>
    val stringsOptionalExist: List<String?>
    val stringsOptionalAbsent: List<String?>
    val stringsRequiredFirstExistSecondAbsent: List<String>
    val stringsOptionalFirstExistSecondAbsent: List<String?>
}