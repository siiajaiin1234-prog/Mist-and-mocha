package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.CafeDataRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

    @Test
    fun `read string from context`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("Mist & Mocha", appName)
    }

    @Test
    fun `articlesCount_isMinimum10_andEachHasPhotoUnder100KB`() {
        val articles = CafeDataRepository.articles
        assertTrue("Articles count must be at least 10", articles.size >= 10)
        articles.forEach { article ->
            assertTrue("Article photo URL or local res must be present", article.imageUrl.isNotBlank() || article.localDrawableRes != null)
            assertTrue("Image size must be strictly under 100 KB", article.imageSizeKb < 100)
        }
    }

    @Test
    fun `articleTitles_haveMainKeyword_andTwoRelatedKeywords`() {
        val articles = CafeDataRepository.articles
        articles.forEach { article ->
            assertTrue("Title should include main keyword", article.title.contains(article.mainKeyword, ignoreCase = true))
            assertEquals("Must have 2 related keywords", 2, article.relatedKeywords.size)
            assertTrue("Main keyword must not be blank", article.mainKeyword.isNotBlank())
        }
    }

    @Test
    fun `articleMetaDescriptions_followRuleGuidelines`() {
        val articles = CafeDataRepository.articles
        articles.forEach { article ->
            assertTrue("Meta description should be descriptive (>= 120 chars)", article.metaDescription.length >= 120)
            assertTrue("Meta description should not exceed 165 chars", article.metaDescription.length <= 165)
        }
    }

    @Test
    fun `articles_containQuestionAndAnswerSubheadings`() {
        val articles = CafeDataRepository.articles
        val hasQaArticles = articles.filter { it.sections.any { s -> s.isQuestionAnswer } }
        assertTrue("Articles should contain Q&A format subheadings", hasQaArticles.size >= 5)
    }
}
