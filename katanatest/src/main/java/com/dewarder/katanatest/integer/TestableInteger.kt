package com.dewarder.katanatest.integer

interface TestableInteger {

    val integerRequiredExist: Int
    val integerRequiredAbsent: Int
    val integerOptionalExist: Int?
    val integerOptionalAbsent: Int?

    val integersRequiredExist: List<Int>
    val integersRequiredAbsent: List<Int>
    val integersOptionalExist: List<Int?>
    val integersOptionalAbsent: List<Int?>
    val integersRequiredFirstExistSecondAbsent: List<Int>
    val integersOptionalFirstExistSecondAbsent: List<Int?>
}