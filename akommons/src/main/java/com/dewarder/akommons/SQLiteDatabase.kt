/*
 * Copyright (C) 2017 Artem Hluhovskyi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

@file:JvmName("SQLiteDatabaseUtils")

package com.dewarder.akommons

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

inline fun <R> SQLiteDatabase.use(block: (SQLiteDatabase) -> R): R {
    var closed = false
    try {
        return block(this)
    } catch (e: Exception) {
        closed = true
        try {
            close()
        } catch (closeException: Exception) {
        }
        throw e
    } finally {
        if (!closed) {
            close()
        }
    }
}

fun SQLiteDatabase.executeQuery(
    table: String,
    columns: Array<String>? = null,
    selection: String? = null,
    selectionArgs: Array<String>? = null,
    groupBy: String? = null,
    having: String? = null,
    orderBy: String? = null,
    limit: String? = null
): Cursor = query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit)

fun SQLiteDatabase.executeInsert(
    table: String,
    nullColumnHack: String? = null,
    values: ContentValues
): Long = insert(table, nullColumnHack, values)

fun SQLiteDatabase.executeUpdate(
    table: String,
    values: ContentValues,
    whereClause: String? = null,
    whereArgs: Array<String>? = null
): Long = update(table, values, whereClause, whereArgs).toLong()

fun SQLiteDatabase.executeDelete(
    table: String,
    whereClause: String? = null,
    whereArgs: Array<String>? = null
): Long = delete(table, whereClause, whereArgs).toLong()