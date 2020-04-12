package emu.dev.spotify_swipe

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import emu.dev.spotify_swipe.api.data.Album
import emu.dev.spotify_swipe.api.data.Artist
import emu.dev.spotify_swipe.api.data.ArtistSimple
import emu.dev.spotify_swipe.api.endpoints.AlbumAPI
import emu.dev.spotify_swipe.api.spotify.SpotifyAPI
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import emu.dev.spotify_swipe.api.spotify.Token
import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.http.cio.parseResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

class AlbumUnitTest {

    private val client = HttpClient {
        install(JsonFeature) {
            serializer = GsonSerializer {
                serializeNulls()
                disableHtmlEscaping()
                setPrettyPrinting()
            }
        }
    }

    private val API = SpotifyAPI(client)


    @Test
    fun testRequestAlbum() = runBlocking<Unit>
    {
        requestAlbum_Functional()
    }

    suspend fun requestAlbum_Functional() {
        delay(10)

        val correctAlbum = "{\n" +
                "  \"album_type\" : \"album\",\n" +
                "  \"artists\" : [ {\n" +
                "    \"external_urls\" : {\n" +
                "      \"spotify\" : \"https://open.spotify.com/artist/2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "    },\n" +
                "    \"href\" : \"https://api.spotify.com/v1/artists/2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "    \"id\" : \"2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "    \"name\" : \"Cyndi Lauper\",\n" +
                "    \"type\" : \"artist\",\n" +
                "    \"uri\" : \"spotify:artist:2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "  } ],\n" +
                "  \"available_markets\" : [ ],\n" +
                "  \"copyrights\" : [ {\n" +
                "    \"text\" : \"(P) 2000 Sony Music Entertainment Inc.\",\n" +
                "    \"type\" : \"P\"\n" +
                "  } ],\n" +
                "  \"external_ids\" : {\n" +
                "    \"upc\" : \"5099749994324\"\n" +
                "  },\n" +
                "  \"external_urls\" : {\n" +
                "    \"spotify\" : \"https://open.spotify.com/album/0sNOF9WDwhWunNAHPD3Baj\"\n" +
                "  },\n" +
                "  \"genres\" : [ ],\n" +
                "  \"href\" : \"https://api.spotify.com/v1/albums/0sNOF9WDwhWunNAHPD3Baj\",\n" +
                "  \"id\" : \"0sNOF9WDwhWunNAHPD3Baj\",\n" +
                "  \"images\" : [ {\n" +
                "    \"height\" : 640,\n" +
                "    \"url\" : \"https://i.scdn.co/image/ab67616d0000b273626d2ce1fb80955645d4d787\",\n" +
                "    \"width\" : 640\n" +
                "  }, {\n" +
                "    \"height\" : 300,\n" +
                "    \"url\" : \"https://i.scdn.co/image/ab67616d00001e02626d2ce1fb80955645d4d787\",\n" +
                "    \"width\" : 300\n" +
                "  }, {\n" +
                "    \"height\" : 64,\n" +
                "    \"url\" : \"https://i.scdn.co/image/ab67616d00004851626d2ce1fb80955645d4d787\",\n" +
                "    \"width\" : 64\n" +
                "  } ],\n" +
                "  \"label\" : \"Epic/Legacy\",\n" +
                "  \"name\" : \"She's So Unusual\",\n" +
                "  \"popularity\" : 0,\n" +
                "  \"release_date\" : \"1983\",\n" +
                "  \"release_date_precision\" : \"year\",\n" +
                "  \"total_tracks\" : 13,\n" +
                "  \"tracks\" : {\n" +
                "    \"href\" : \"https://api.spotify.com/v1/albums/0sNOF9WDwhWunNAHPD3Baj/tracks?offset=0&limit=50\",\n" +
                "    \"items\" : [ {\n" +
                "      \"artists\" : [ {\n" +
                "        \"external_urls\" : {\n" +
                "          \"spotify\" : \"https://open.spotify.com/artist/2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "        },\n" +
                "        \"href\" : \"https://api.spotify.com/v1/artists/2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"id\" : \"2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"name\" : \"Cyndi Lauper\",\n" +
                "        \"type\" : \"artist\",\n" +
                "        \"uri\" : \"spotify:artist:2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "      } ],\n" +
                "      \"available_markets\" : [ ],\n" +
                "      \"disc_number\" : 1,\n" +
                "      \"duration_ms\" : 305560,\n" +
                "      \"explicit\" : false,\n" +
                "      \"external_urls\" : {\n" +
                "        \"spotify\" : \"https://open.spotify.com/track/3f9zqUnrnIq0LANhmnaF0V\"\n" +
                "      },\n" +
                "      \"href\" : \"https://api.spotify.com/v1/tracks/3f9zqUnrnIq0LANhmnaF0V\",\n" +
                "      \"id\" : \"3f9zqUnrnIq0LANhmnaF0V\",\n" +
                "      \"is_local\" : false,\n" +
                "      \"name\" : \"Money Changes Everything\",\n" +
                "      \"preview_url\" : null,\n" +
                "      \"track_number\" : 1,\n" +
                "      \"type\" : \"track\",\n" +
                "      \"uri\" : \"spotify:track:3f9zqUnrnIq0LANhmnaF0V\"\n" +
                "    }, {\n" +
                "      \"artists\" : [ {\n" +
                "        \"external_urls\" : {\n" +
                "          \"spotify\" : \"https://open.spotify.com/artist/2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "        },\n" +
                "        \"href\" : \"https://api.spotify.com/v1/artists/2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"id\" : \"2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"name\" : \"Cyndi Lauper\",\n" +
                "        \"type\" : \"artist\",\n" +
                "        \"uri\" : \"spotify:artist:2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "      } ],\n" +
                "      \"available_markets\" : [ ],\n" +
                "      \"disc_number\" : 1,\n" +
                "      \"duration_ms\" : 238266,\n" +
                "      \"explicit\" : false,\n" +
                "      \"external_urls\" : {\n" +
                "        \"spotify\" : \"https://open.spotify.com/track/2joHDtKFVDDyWDHnOxZMAX\"\n" +
                "      },\n" +
                "      \"href\" : \"https://api.spotify.com/v1/tracks/2joHDtKFVDDyWDHnOxZMAX\",\n" +
                "      \"id\" : \"2joHDtKFVDDyWDHnOxZMAX\",\n" +
                "      \"is_local\" : false,\n" +
                "      \"name\" : \"Girls Just Want to Have Fun\",\n" +
                "      \"preview_url\" : null,\n" +
                "      \"track_number\" : 2,\n" +
                "      \"type\" : \"track\",\n" +
                "      \"uri\" : \"spotify:track:2joHDtKFVDDyWDHnOxZMAX\"\n" +
                "    }, {\n" +
                "      \"artists\" : [ {\n" +
                "        \"external_urls\" : {\n" +
                "          \"spotify\" : \"https://open.spotify.com/artist/2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "        },\n" +
                "        \"href\" : \"https://api.spotify.com/v1/artists/2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"id\" : \"2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"name\" : \"Cyndi Lauper\",\n" +
                "        \"type\" : \"artist\",\n" +
                "        \"uri\" : \"spotify:artist:2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "      } ],\n" +
                "      \"available_markets\" : [ ],\n" +
                "      \"disc_number\" : 1,\n" +
                "      \"duration_ms\" : 306706,\n" +
                "      \"explicit\" : false,\n" +
                "      \"external_urls\" : {\n" +
                "        \"spotify\" : \"https://open.spotify.com/track/6ClztHzretmPHCeiNqR5wD\"\n" +
                "      },\n" +
                "      \"href\" : \"https://api.spotify.com/v1/tracks/6ClztHzretmPHCeiNqR5wD\",\n" +
                "      \"id\" : \"6ClztHzretmPHCeiNqR5wD\",\n" +
                "      \"is_local\" : false,\n" +
                "      \"name\" : \"When You Were Mine\",\n" +
                "      \"preview_url\" : null,\n" +
                "      \"track_number\" : 3,\n" +
                "      \"type\" : \"track\",\n" +
                "      \"uri\" : \"spotify:track:6ClztHzretmPHCeiNqR5wD\"\n" +
                "    }, {\n" +
                "      \"artists\" : [ {\n" +
                "        \"external_urls\" : {\n" +
                "          \"spotify\" : \"https://open.spotify.com/artist/2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "        },\n" +
                "        \"href\" : \"https://api.spotify.com/v1/artists/2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"id\" : \"2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"name\" : \"Cyndi Lauper\",\n" +
                "        \"type\" : \"artist\",\n" +
                "        \"uri\" : \"spotify:artist:2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "      } ],\n" +
                "      \"available_markets\" : [ ],\n" +
                "      \"disc_number\" : 1,\n" +
                "      \"duration_ms\" : 241333,\n" +
                "      \"explicit\" : false,\n" +
                "      \"external_urls\" : {\n" +
                "        \"spotify\" : \"https://open.spotify.com/track/2tVHvZK4YYzTloSCBPm2tg\"\n" +
                "      },\n" +
                "      \"href\" : \"https://api.spotify.com/v1/tracks/2tVHvZK4YYzTloSCBPm2tg\",\n" +
                "      \"id\" : \"2tVHvZK4YYzTloSCBPm2tg\",\n" +
                "      \"is_local\" : false,\n" +
                "      \"name\" : \"Time After Time\",\n" +
                "      \"preview_url\" : null,\n" +
                "      \"track_number\" : 4,\n" +
                "      \"type\" : \"track\",\n" +
                "      \"uri\" : \"spotify:track:2tVHvZK4YYzTloSCBPm2tg\"\n" +
                "    }, {\n" +
                "      \"artists\" : [ {\n" +
                "        \"external_urls\" : {\n" +
                "          \"spotify\" : \"https://open.spotify.com/artist/2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "        },\n" +
                "        \"href\" : \"https://api.spotify.com/v1/artists/2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"id\" : \"2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"name\" : \"Cyndi Lauper\",\n" +
                "        \"type\" : \"artist\",\n" +
                "        \"uri\" : \"spotify:artist:2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "      } ],\n" +
                "      \"available_markets\" : [ ],\n" +
                "      \"disc_number\" : 1,\n" +
                "      \"duration_ms\" : 229266,\n" +
                "      \"explicit\" : false,\n" +
                "      \"external_urls\" : {\n" +
                "        \"spotify\" : \"https://open.spotify.com/track/6iLhMDtOr52OVXaZdha5M6\"\n" +
                "      },\n" +
                "      \"href\" : \"https://api.spotify.com/v1/tracks/6iLhMDtOr52OVXaZdha5M6\",\n" +
                "      \"id\" : \"6iLhMDtOr52OVXaZdha5M6\",\n" +
                "      \"is_local\" : false,\n" +
                "      \"name\" : \"She Bop\",\n" +
                "      \"preview_url\" : null,\n" +
                "      \"track_number\" : 5,\n" +
                "      \"type\" : \"track\",\n" +
                "      \"uri\" : \"spotify:track:6iLhMDtOr52OVXaZdha5M6\"\n" +
                "    }, {\n" +
                "      \"artists\" : [ {\n" +
                "        \"external_urls\" : {\n" +
                "          \"spotify\" : \"https://open.spotify.com/artist/2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "        },\n" +
                "        \"href\" : \"https://api.spotify.com/v1/artists/2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"id\" : \"2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"name\" : \"Cyndi Lauper\",\n" +
                "        \"type\" : \"artist\",\n" +
                "        \"uri\" : \"spotify:artist:2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "      } ],\n" +
                "      \"available_markets\" : [ ],\n" +
                "      \"disc_number\" : 1,\n" +
                "      \"duration_ms\" : 272840,\n" +
                "      \"explicit\" : false,\n" +
                "      \"external_urls\" : {\n" +
                "        \"spotify\" : \"https://open.spotify.com/track/3csiLr2B2wRj4lsExn6jLf\"\n" +
                "      },\n" +
                "      \"href\" : \"https://api.spotify.com/v1/tracks/3csiLr2B2wRj4lsExn6jLf\",\n" +
                "      \"id\" : \"3csiLr2B2wRj4lsExn6jLf\",\n" +
                "      \"is_local\" : false,\n" +
                "      \"name\" : \"All Through the Night\",\n" +
                "      \"preview_url\" : null,\n" +
                "      \"track_number\" : 6,\n" +
                "      \"type\" : \"track\",\n" +
                "      \"uri\" : \"spotify:track:3csiLr2B2wRj4lsExn6jLf\"\n" +
                "    }, {\n" +
                "      \"artists\" : [ {\n" +
                "        \"external_urls\" : {\n" +
                "          \"spotify\" : \"https://open.spotify.com/artist/2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "        },\n" +
                "        \"href\" : \"https://api.spotify.com/v1/artists/2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"id\" : \"2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"name\" : \"Cyndi Lauper\",\n" +
                "        \"type\" : \"artist\",\n" +
                "        \"uri\" : \"spotify:artist:2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "      } ],\n" +
                "      \"available_markets\" : [ ],\n" +
                "      \"disc_number\" : 1,\n" +
                "      \"duration_ms\" : 220333,\n" +
                "      \"explicit\" : false,\n" +
                "      \"external_urls\" : {\n" +
                "        \"spotify\" : \"https://open.spotify.com/track/4mRAnuBGYsW4WGbpW0QUkp\"\n" +
                "      },\n" +
                "      \"href\" : \"https://api.spotify.com/v1/tracks/4mRAnuBGYsW4WGbpW0QUkp\",\n" +
                "      \"id\" : \"4mRAnuBGYsW4WGbpW0QUkp\",\n" +
                "      \"is_local\" : false,\n" +
                "      \"name\" : \"Witness\",\n" +
                "      \"preview_url\" : null,\n" +
                "      \"track_number\" : 7,\n" +
                "      \"type\" : \"track\",\n" +
                "      \"uri\" : \"spotify:track:4mRAnuBGYsW4WGbpW0QUkp\"\n" +
                "    }, {\n" +
                "      \"artists\" : [ {\n" +
                "        \"external_urls\" : {\n" +
                "          \"spotify\" : \"https://open.spotify.com/artist/2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "        },\n" +
                "        \"href\" : \"https://api.spotify.com/v1/artists/2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"id\" : \"2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"name\" : \"Cyndi Lauper\",\n" +
                "        \"type\" : \"artist\",\n" +
                "        \"uri\" : \"spotify:artist:2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "      } ],\n" +
                "      \"available_markets\" : [ ],\n" +
                "      \"disc_number\" : 1,\n" +
                "      \"duration_ms\" : 252626,\n" +
                "      \"explicit\" : false,\n" +
                "      \"external_urls\" : {\n" +
                "        \"spotify\" : \"https://open.spotify.com/track/3AIeUnffkLQaUaX1pkHyeD\"\n" +
                "      },\n" +
                "      \"href\" : \"https://api.spotify.com/v1/tracks/3AIeUnffkLQaUaX1pkHyeD\",\n" +
                "      \"id\" : \"3AIeUnffkLQaUaX1pkHyeD\",\n" +
                "      \"is_local\" : false,\n" +
                "      \"name\" : \"I'll Kiss You\",\n" +
                "      \"preview_url\" : null,\n" +
                "      \"track_number\" : 8,\n" +
                "      \"type\" : \"track\",\n" +
                "      \"uri\" : \"spotify:track:3AIeUnffkLQaUaX1pkHyeD\"\n" +
                "    }, {\n" +
                "      \"artists\" : [ {\n" +
                "        \"external_urls\" : {\n" +
                "          \"spotify\" : \"https://open.spotify.com/artist/2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "        },\n" +
                "        \"href\" : \"https://api.spotify.com/v1/artists/2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"id\" : \"2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"name\" : \"Cyndi Lauper\",\n" +
                "        \"type\" : \"artist\",\n" +
                "        \"uri\" : \"spotify:artist:2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "      } ],\n" +
                "      \"available_markets\" : [ ],\n" +
                "      \"disc_number\" : 1,\n" +
                "      \"duration_ms\" : 45933,\n" +
                "      \"explicit\" : false,\n" +
                "      \"external_urls\" : {\n" +
                "        \"spotify\" : \"https://open.spotify.com/track/53eCpAFNbA9MQNfLilN3CH\"\n" +
                "      },\n" +
                "      \"href\" : \"https://api.spotify.com/v1/tracks/53eCpAFNbA9MQNfLilN3CH\",\n" +
                "      \"id\" : \"53eCpAFNbA9MQNfLilN3CH\",\n" +
                "      \"is_local\" : false,\n" +
                "      \"name\" : \"He's so Unusual\",\n" +
                "      \"preview_url\" : null,\n" +
                "      \"track_number\" : 9,\n" +
                "      \"type\" : \"track\",\n" +
                "      \"uri\" : \"spotify:track:53eCpAFNbA9MQNfLilN3CH\"\n" +
                "    }, {\n" +
                "      \"artists\" : [ {\n" +
                "        \"external_urls\" : {\n" +
                "          \"spotify\" : \"https://open.spotify.com/artist/2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "        },\n" +
                "        \"href\" : \"https://api.spotify.com/v1/artists/2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"id\" : \"2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"name\" : \"Cyndi Lauper\",\n" +
                "        \"type\" : \"artist\",\n" +
                "        \"uri\" : \"spotify:artist:2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "      } ],\n" +
                "      \"available_markets\" : [ ],\n" +
                "      \"disc_number\" : 1,\n" +
                "      \"duration_ms\" : 196373,\n" +
                "      \"explicit\" : false,\n" +
                "      \"external_urls\" : {\n" +
                "        \"spotify\" : \"https://open.spotify.com/track/51JS0KXziu9U1T8EBdRTUF\"\n" +
                "      },\n" +
                "      \"href\" : \"https://api.spotify.com/v1/tracks/51JS0KXziu9U1T8EBdRTUF\",\n" +
                "      \"id\" : \"51JS0KXziu9U1T8EBdRTUF\",\n" +
                "      \"is_local\" : false,\n" +
                "      \"name\" : \"Yeah Yeah\",\n" +
                "      \"preview_url\" : null,\n" +
                "      \"track_number\" : 10,\n" +
                "      \"type\" : \"track\",\n" +
                "      \"uri\" : \"spotify:track:51JS0KXziu9U1T8EBdRTUF\"\n" +
                "    }, {\n" +
                "      \"artists\" : [ {\n" +
                "        \"external_urls\" : {\n" +
                "          \"spotify\" : \"https://open.spotify.com/artist/2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "        },\n" +
                "        \"href\" : \"https://api.spotify.com/v1/artists/2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"id\" : \"2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"name\" : \"Cyndi Lauper\",\n" +
                "        \"type\" : \"artist\",\n" +
                "        \"uri\" : \"spotify:artist:2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "      } ],\n" +
                "      \"available_markets\" : [ ],\n" +
                "      \"disc_number\" : 1,\n" +
                "      \"duration_ms\" : 275560,\n" +
                "      \"explicit\" : false,\n" +
                "      \"external_urls\" : {\n" +
                "        \"spotify\" : \"https://open.spotify.com/track/2BGJvRarwOa2kiIGpLjIXT\"\n" +
                "      },\n" +
                "      \"href\" : \"https://api.spotify.com/v1/tracks/2BGJvRarwOa2kiIGpLjIXT\",\n" +
                "      \"id\" : \"2BGJvRarwOa2kiIGpLjIXT\",\n" +
                "      \"is_local\" : false,\n" +
                "      \"name\" : \"Money Changes Everything\",\n" +
                "      \"preview_url\" : null,\n" +
                "      \"track_number\" : 11,\n" +
                "      \"type\" : \"track\",\n" +
                "      \"uri\" : \"spotify:track:2BGJvRarwOa2kiIGpLjIXT\"\n" +
                "    }, {\n" +
                "      \"artists\" : [ {\n" +
                "        \"external_urls\" : {\n" +
                "          \"spotify\" : \"https://open.spotify.com/artist/2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "        },\n" +
                "        \"href\" : \"https://api.spotify.com/v1/artists/2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"id\" : \"2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"name\" : \"Cyndi Lauper\",\n" +
                "        \"type\" : \"artist\",\n" +
                "        \"uri\" : \"spotify:artist:2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "      } ],\n" +
                "      \"available_markets\" : [ ],\n" +
                "      \"disc_number\" : 1,\n" +
                "      \"duration_ms\" : 320400,\n" +
                "      \"explicit\" : false,\n" +
                "      \"external_urls\" : {\n" +
                "        \"spotify\" : \"https://open.spotify.com/track/5ggatiDTbCIJsUAa7IUP65\"\n" +
                "      },\n" +
                "      \"href\" : \"https://api.spotify.com/v1/tracks/5ggatiDTbCIJsUAa7IUP65\",\n" +
                "      \"id\" : \"5ggatiDTbCIJsUAa7IUP65\",\n" +
                "      \"is_local\" : false,\n" +
                "      \"name\" : \"She Bop - Live\",\n" +
                "      \"preview_url\" : null,\n" +
                "      \"track_number\" : 12,\n" +
                "      \"type\" : \"track\",\n" +
                "      \"uri\" : \"spotify:track:5ggatiDTbCIJsUAa7IUP65\"\n" +
                "    }, {\n" +
                "      \"artists\" : [ {\n" +
                "        \"external_urls\" : {\n" +
                "          \"spotify\" : \"https://open.spotify.com/artist/2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "        },\n" +
                "        \"href\" : \"https://api.spotify.com/v1/artists/2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"id\" : \"2BTZIqw0ntH9MvilQ3ewNY\",\n" +
                "        \"name\" : \"Cyndi Lauper\",\n" +
                "        \"type\" : \"artist\",\n" +
                "        \"uri\" : \"spotify:artist:2BTZIqw0ntH9MvilQ3ewNY\"\n" +
                "      } ],\n" +
                "      \"available_markets\" : [ ],\n" +
                "      \"disc_number\" : 1,\n" +
                "      \"duration_ms\" : 288240,\n" +
                "      \"explicit\" : false,\n" +
                "      \"external_urls\" : {\n" +
                "        \"spotify\" : \"https://open.spotify.com/track/5ZBxoa2kBrBah3qNIV4rm7\"\n" +
                "      },\n" +
                "      \"href\" : \"https://api.spotify.com/v1/tracks/5ZBxoa2kBrBah3qNIV4rm7\",\n" +
                "      \"id\" : \"5ZBxoa2kBrBah3qNIV4rm7\",\n" +
                "      \"is_local\" : false,\n" +
                "      \"name\" : \"All Through The Night - Live\",\n" +
                "      \"preview_url\" : null,\n" +
                "      \"track_number\" : 13,\n" +
                "      \"type\" : \"track\",\n" +
                "      \"uri\" : \"spotify:track:5ZBxoa2kBrBah3qNIV4rm7\"\n" +
                "    } ],\n" +
                "    \"limit\" : 50,\n" +
                "    \"next\" : null,\n" +
                "    \"offset\" : 0,\n" +
                "    \"previous\" : null,\n" +
                "    \"total\" : 13\n" +
                "  },\n" +
                "  \"type\" : \"album\",\n" +
                "  \"uri\" : \"spotify:album:0sNOF9WDwhWunNAHPD3Baj\"\n" +
                "}"


        val spotifyRequest = SpotifyRequest(client, API.clientCredentialsRequest())
        val albumAPI = AlbumAPI(spotifyRequest)
        val requestOutput = albumAPI.requestAlbum("0sNOF9WDwhWunNAHPD3Baj")
        val testOutput = albumAPI.getTestResponse()

        assertEquals(correctAlbum, testOutput)
    }

    @Test
    fun testRequestAlbumTracks() = runBlocking<Unit>
    {
        requestAlbumTracks_Functional()
    }

    suspend fun requestAlbumTracks_Functional()
    {
        delay(10)

        val correctAlbum = "{\n" +
                "  \"href\" : \"https://api.spotify.com/v1/albums/6akEvsycLGftJxYudPjmqK/tracks?offset=0&limit=2\",\n" +
                "  \"items\" : [ {\n" +
                "    \"artists\" : [ {\n" +
                "      \"external_urls\" : {\n" +
                "        \"spotify\" : \"https://open.spotify.com/artist/08td7MxkoHQkXnWAYD8d6Q\"\n" +
                "      },\n" +
                "      \"href\" : \"https://api.spotify.com/v1/artists/08td7MxkoHQkXnWAYD8d6Q\",\n" +
                "      \"id\" : \"08td7MxkoHQkXnWAYD8d6Q\",\n" +
                "      \"name\" : \"Tania Bowra\",\n" +
                "      \"type\" : \"artist\",\n" +
                "      \"uri\" : \"spotify:artist:08td7MxkoHQkXnWAYD8d6Q\"\n" +
                "    } ],\n" +
                "    \"available_markets\" : [ \"AD\", \"AE\", \"AR\", \"AT\", \"AU\", \"BE\", \"BG\", \"BH\", \"BO\", \"BR\", \"CA\", \"CH\", \"CL\", \"CO\", \"CR\", \"CY\", \"CZ\", \"DE\", \"DK\", \"DO\", \"DZ\", \"EC\", \"EE\", \"EG\", \"ES\", \"FI\", \"FR\", \"GB\", \"GR\", \"GT\", \"HK\", \"HN\", \"HU\", \"ID\", \"IE\", \"IL\", \"IN\", \"IS\", \"IT\", \"JO\", \"JP\", \"KW\", \"LB\", \"LI\", \"LT\", \"LU\", \"LV\", \"MA\", \"MC\", \"MT\", \"MX\", \"MY\", \"NI\", \"NL\", \"NO\", \"NZ\", \"OM\", \"PA\", \"PE\", \"PH\", \"PL\", \"PS\", \"PT\", \"PY\", \"QA\", \"RO\", \"SA\", \"SE\", \"SG\", \"SK\", \"SV\", \"TH\", \"TN\", \"TR\", \"TW\", \"US\", \"UY\", \"VN\", \"ZA\" ],\n" +
                "    \"disc_number\" : 1,\n" +
                "    \"duration_ms\" : 276773,\n" +
                "    \"explicit\" : false,\n" +
                "    \"external_urls\" : {\n" +
                "      \"spotify\" : \"https://open.spotify.com/track/2TpxZ7JUBn3uw46aR7qd6V\"\n" +
                "    },\n" +
                "    \"href\" : \"https://api.spotify.com/v1/tracks/2TpxZ7JUBn3uw46aR7qd6V\",\n" +
                "    \"id\" : \"2TpxZ7JUBn3uw46aR7qd6V\",\n" +
                "    \"is_local\" : false,\n" +
                "    \"name\" : \"All I Want\",\n" +
                "    \"preview_url\" : \"https://p.scdn.co/mp3-preview/12b8cee72118f995f5494e1b34251e4ac997445e?cid=3a36e58be96b4c4ab8829fb5702d05a5\",\n" +
                "    \"track_number\" : 1,\n" +
                "    \"type\" : \"track\",\n" +
                "    \"uri\" : \"spotify:track:2TpxZ7JUBn3uw46aR7qd6V\"\n" +
                "  }, {\n" +
                "    \"artists\" : [ {\n" +
                "      \"external_urls\" : {\n" +
                "        \"spotify\" : \"https://open.spotify.com/artist/08td7MxkoHQkXnWAYD8d6Q\"\n" +
                "      },\n" +
                "      \"href\" : \"https://api.spotify.com/v1/artists/08td7MxkoHQkXnWAYD8d6Q\",\n" +
                "      \"id\" : \"08td7MxkoHQkXnWAYD8d6Q\",\n" +
                "      \"name\" : \"Tania Bowra\",\n" +
                "      \"type\" : \"artist\",\n" +
                "      \"uri\" : \"spotify:artist:08td7MxkoHQkXnWAYD8d6Q\"\n" +
                "    } ],\n" +
                "    \"available_markets\" : [ \"AD\", \"AE\", \"AR\", \"AT\", \"AU\", \"BE\", \"BG\", \"BH\", \"BO\", \"BR\", \"CA\", \"CH\", \"CL\", \"CO\", \"CR\", \"CY\", \"CZ\", \"DE\", \"DK\", \"DO\", \"DZ\", \"EC\", \"EE\", \"EG\", \"ES\", \"FI\", \"FR\", \"GB\", \"GR\", \"GT\", \"HK\", \"HN\", \"HU\", \"ID\", \"IE\", \"IL\", \"IN\", \"IS\", \"IT\", \"JO\", \"JP\", \"KW\", \"LB\", \"LI\", \"LT\", \"LU\", \"LV\", \"MA\", \"MC\", \"MT\", \"MX\", \"MY\", \"NI\", \"NL\", \"NO\", \"NZ\", \"OM\", \"PA\", \"PE\", \"PH\", \"PL\", \"PS\", \"PT\", \"PY\", \"QA\", \"RO\", \"SA\", \"SE\", \"SG\", \"SK\", \"SV\", \"TH\", \"TN\", \"TR\", \"TW\", \"US\", \"UY\", \"VN\", \"ZA\" ],\n" +
                "    \"disc_number\" : 1,\n" +
                "    \"duration_ms\" : 247680,\n" +
                "    \"explicit\" : false,\n" +
                "    \"external_urls\" : {\n" +
                "      \"spotify\" : \"https://open.spotify.com/track/4PjcfyZZVE10TFd9EKA72r\"\n" +
                "    },\n" +
                "    \"href\" : \"https://api.spotify.com/v1/tracks/4PjcfyZZVE10TFd9EKA72r\",\n" +
                "    \"id\" : \"4PjcfyZZVE10TFd9EKA72r\",\n" +
                "    \"is_local\" : false,\n" +
                "    \"name\" : \"Someday\",\n" +
                "    \"preview_url\" : \"https://p.scdn.co/mp3-preview/4a54d83c195d0bc17b1b23fc931d37fb363224d8?cid=3a36e58be96b4c4ab8829fb5702d05a5\",\n" +
                "    \"track_number\" : 2,\n" +
                "    \"type\" : \"track\",\n" +
                "    \"uri\" : \"spotify:track:4PjcfyZZVE10TFd9EKA72r\"\n" +
                "  } ],\n" +
                "  \"limit\" : 2,\n" +
                "  \"next\" : \"https://api.spotify.com/v1/albums/6akEvsycLGftJxYudPjmqK/tracks?offset=2&limit=2\",\n" +
                "  \"offset\" : 0,\n" +
                "  \"previous\" : null,\n" +
                "  \"total\" : 11\n" +
                "}"

        val spotifyRequest = SpotifyRequest(client, API.clientCredentialsRequest())
        val albumAPI = AlbumAPI(spotifyRequest)
        val requestOutput = albumAPI.requestAlbumTracks("6akEvsycLGftJxYudPjmqK",2,0)
        val testOutput = albumAPI.getTestResponse()

        assertEquals(correctAlbum, testOutput)
    }

    @Test
    fun testRequestAlbums() = runBlocking<Unit>
    {
        requestAlbums_Functional()
    }

    suspend fun requestAlbums_Functional()
    {
        delay(10)

        val correctAlbum = ""

        val spotifyRequest = SpotifyRequest(client, API.clientCredentialsRequest())
        val albumAPI = AlbumAPI(spotifyRequest)
        albumAPI.requestAlbums("41MnTivkwTO3UUJ8DrqEJJ","6JWc4iAiJ9FjyK0B59ABb4","6UXCm6bOO4gFlDQZV5yL37")
        val testOutput = albumAPI.getTestResponse()

        assertEquals(correctAlbum, testOutput)
    }

}