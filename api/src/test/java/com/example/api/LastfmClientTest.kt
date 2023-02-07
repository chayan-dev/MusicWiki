package com.example.api

import junit.framework.TestCase
import org.junit.Test

class LastfmClientTest {
  private val lastfmClient = LastfmClient

  @Test
  fun `GET getTags`() {
    val tags = lastfmClient.api.getTags().execute()
    TestCase.assertNotNull(tags.body()?.toptags?.tag)
  }

  @Test
  fun `GET getTopAlbumsByTag`() {
    val tags = lastfmClient.api.getTopAlbumsByTag(tag = "disco").execute()
    TestCase.assertNotNull(tags.body()?.albums?.album)
  }
}