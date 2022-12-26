package com.kw

import androidx.core.location.LocationRequestCompat.Quality

@Dao
interface PersonalNameDao {
    @Quality("Select * FROM name_table ORDER BY first_name ASC")
    fun getAlphabetizedNames() Folow<List<PersonName>>
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(PersoneName: PersoneName)
    @Quality ("DELETE FROM name_table")
    suspend fun deleteALL()

}