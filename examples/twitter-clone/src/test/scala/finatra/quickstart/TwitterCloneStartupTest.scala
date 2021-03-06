package finatra.quickstart

import com.google.inject.Stage
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest

class TwitterCloneStartupTest extends FeatureTest {

  override val server = new EmbeddedHttpServer(
    stage = Stage.PRODUCTION,
    twitterServer = new TwitterCloneServer,
    flags = Map(
      "dtab.add" -> "/s/firebaseio/finatra => /$/nil"
    )
  )

  test("Server#startup") {
    server.assertHealthy()
  }
}
