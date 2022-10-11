package com.example.shindepratik.ui.repo

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.shindepratik.ends.Ends
import com.example.shindepratik.ends.Unk
import com.example.shindepratik.ends.UnkDto
import retrofit2.HttpException
import java.io.IOException

private const val DEFAULT_PAGE = 1

class UnkownPgSource (
    private val ends: Ends
) : PagingSource<Int, UnkDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnkDto> {

        val position = params.key ?: DEFAULT_PAGE

        return try {

            val response = ends.getUnknownResponse(position)

            LoadResult.Page(
                data = response.data,
                prevKey = if (position == DEFAULT_PAGE) null else position - 1,
                nextKey = if (response.data.isEmpty()) null else position + 1
            )

        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UnkDto>): Int {
        return 1
    }

}