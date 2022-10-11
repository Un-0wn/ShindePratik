package com.example.shindepratik.ui.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.shindepratik.ends.Ends
import com.example.shindepratik.ends.UnkDto
import com.example.shindepratik.ends.UserDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PgRespos @Inject constructor(
    private val ends: Ends
) {

    fun getUser(): Flow<PagingData<UserDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = 6,
            ),
            pagingSourceFactory = {
                UserPgSource(
                    ends,
                )
            }
        ).flow
    }

    fun getUnknown() : Flow<PagingData<UnkDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = 6,
            ),
            pagingSourceFactory = {
                UnkownPgSource(
                    ends,
                )
            }
        ).flow
    }

}