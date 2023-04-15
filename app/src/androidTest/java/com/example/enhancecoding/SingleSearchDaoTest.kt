package com.example.enhancecoding

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.enhancecoding.db.SingleSearchDB
import com.example.enhancecoding.db.SingleSearchDao
import com.example.enhancecoding.model.Image
import com.example.enhancecoding.model.SingleSearchResponseModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.test.runTest
import org.junit.*
import javax.inject.Inject

@HiltAndroidTest
class SingleSearchDaoTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val hiltAndroidRule = HiltAndroidRule(this)

    @Inject
    lateinit var singleSearchDB: SingleSearchDB
    private lateinit var singleSearchDao: SingleSearchDao

    @Before
    fun setUp() {
        hiltAndroidRule.inject()
        singleSearchDao = singleSearchDB.singleSearchDao()
    }

    @Test
    fun insertSearchData() = runTest {
        val singleSearchResponseModel = SingleSearchResponseModel(1, "TestName", "TestPremiered",
            Image("https://static.tvmaze.com/uploads/images/medium_portrait/42/106320.jpg",
            "https://static.tvmaze.com/uploads/images/medium_portrait/42/106320.jpg"))

        singleSearchDao.insertSingleSearch(singleSearchResponseModel)
        val result = singleSearchDao.getSingleSearchData("TestName")
        Assert.assertEquals("TestName", result.name)
    }

    @After
    fun closeDatabase() {
        singleSearchDB.close()
    }
}