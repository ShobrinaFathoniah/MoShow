package com.shobrinaf.utils

import com.shobrinaf.data.source.local.entity.MovieEntity
import com.shobrinaf.data.source.local.entity.TvShowEntity
import com.shobrinaf.data.source.remote.response.MovieResponse
import com.shobrinaf.data.source.remote.response.TvShowResponse

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()
        movies.add(
                MovieEntity(
                        58107,
                        "Black★Rock Shooter (2010)",
                        "07/07/2010 (JP)",
                        "Drama, Animation, Fantasy",
                        "52m",
                        "The story of two girls bound in friendship, as well as Black Rock Star's struggle unfolding in another world. But when the two worlds come together... what will happen?",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/tc2I5OQqDr13WF178I3C0rCX9iu.jpg",
                        false
                )
        )
        movies.add(
                MovieEntity(
                        504253,
                        "I Want to Eat Your Pancreas (2018)",
                        "09/01/2018 (JP)",
                        "Animation, Drama, Romance, Family",
                        "1h 48m",
                        "Spring time in April and the last of the cherry blossoms are still in bloom. The usually aloof bookworm with no interest in others comes across a book in a hospital waiting room. Handwritten on the cover are the words: \"Living with Dying.\" He soon discovers that it is a diary kept by his very popular and genuinely cheerful classmate, Sakura Yamauchi, who reveals to him that she is secretly suffering from a pancreatic illness and only has a limited time left. It is at this moment that she gains just one more person to share her secret. Trying to maintain a normal life as much as possible, Sakura is determined to live her life to the fullest until the very last day. As her free spirit and unpredictable actions throw him for a loop, his heart begins to gradually change.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/vHdVU0HyyB6k6kuYt8qjwTz9one.jpg",
                        false
                )
        )
        movies.add(
                MovieEntity(
                        372058,
                        "Your Name (2016)",
                        "08/26/2016 (JP)",
                        "Romance, Animation, Drama",
                        "1h 46m",
                        "High schoolers Mitsuha and Taki are complete strangers living separate lives. But one night, they suddenly switch places. Mitsuha wakes up in Taki’s body, and he in hers. This bizarre occurrence continues to happen randomly, and the two must adjust their lives around each other.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/q719jXXEzOoYaps6babgKnONONX.jpg",
                        false
                )
        )
        movies.add(
                MovieEntity(
                        378064,
                        "A Silent Voice: The Movie (2016)",
                        "09/17/2016 (JP)",
                        "Animation, Drama, Romance",
                        "2h 10m",
                        "Shouya Ishida starts bullying the new girl in class, Shouko Nishimiya, because she is deaf. But as the teasing continues, the rest of the class starts to turn on Shouya for his lack of compassion. When they leave elementary school, Shouko and Shouya do not speak to each other again... until an older, wiser Shouya, tormented by his past behaviour, decides he must see Shouko once more. He wants to atone for his sins, but is it already too late...?",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/tuFaWiqX0TXoWu7DGNcmX3UW7sT.jpg",
                        false
                )
        )
        movies.add(
                MovieEntity(
                        412383,
                        "Fleet Girls Collection KanColle Movie Sequence (2016)",
                        "11/26/2016 (JP)",
                        "Animation, Science Fiction, War, Action",
                        "1h 33m",
                        "The staff at the \"Dai-Ni-Kai \'KanColle\' Kankanshiki\" event in Yokohama in August 2015 announced that the Kantai Collection franchise will get an anime film in 2016. The event screened footage that features the Kan-musume characters Fubuki, Mutsuki, Yuudachi, Akagi and Kaga, Hiryuu Kaini and Souryuu Kaini, the four Kongou sisters (Kaini), Kitakami and Ooi, Choukai Kaini, Yuubari, Mutsu and Nagato, Kako Kaini and Furutaka Kaini, Zuikaku and Shoukaku, Shimakaze, Kuma, and Ouyodo. ",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/grjoz79lPmeljxxipUgE8mzvXIG.jpg",
                        false
                )
        )
        movies.add(
                MovieEntity(
                        482150,
                        "Liz and the Blue Bird (2018)",
                        "04/21/2018 (JP)",
                        "Animation, Drama, Music",
                        "1h 30m",
                        "Two girls grow closer as they practice for their last duet before graduating, a piece called \"Liz And The Blue Bird\".",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/7xRIkqWJy4cNpUxPo5aZ24O0Tyx.jpg",
                        false
                )
        )
        movies.add(
                MovieEntity(
                        528225,
                        "Sound! Euphonium the Movie - Our Promise: A Brand New Day (2019)",
                        "04/19/2019 (JP)",
                        "Animation, Drama",
                        "1h 40m",
                        "Kumiko is now a second year and one of the senior players of the euphonium section. With new underclassmen joining the concert band, Kumiko will have to learn new things in order to deal with awkward and difficult underclassmen. She and third-year trumpeter Tomoe Kabe have been chosen to lead the new underclassmen members. Among the new members to Kumiko's bass section are euphonist Kanade Hisaishi, whose appearances are deceiving; tuba player Mirei Suzuki, who cannot adapt to her new environment; tuba player Satsuki Suzuki, who wants to get along with Mirei; and double bassist Motomu Tsukinaga, who cannot talk about himself. Between the Sunrise Festival, chair placement auditions, and the competition, a number of problems quickly begin to arise.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/azIvdBzPlFUkY5TCFhgXcUZLq5f.jpg",
                        false
                )
        )
        movies.add(
                MovieEntity(
                        533514,
                        "Violet Evergarden: The Movie (2020)",
                        "03/03/2021 (ID)",
                        "Animation, Drama, Romance, Fantasy",
                        "2h 20m",
                        "After working as an Auto Memory Doll, Violet Evergarden has come to learn the meaning of the words \"I love you.\" Her soul, which has been deeply scarred by the war, has begun to heal. She continues to move forward in life, helping others in need, while keeping the words of the first person who ever said \"I love you\" to her close to her heart. When she takes on a job to write a letter for a terminally-ill boy, time starts to move forward.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/fwSonK8WrAEqWY7sqjvGRCgzIij.jpg",
                        false
                )
        )
        movies.add(
                MovieEntity(
                        615165,
                        "Her Blue Sky (2019)",
                        "03/11/2020 (ID)",
                        "Animation, Romance",
                        "1h 48m",
                        "High school student Aoi lives with her elder sister, Akane, after a tragic accident took their parents away 13 years ago. Because Akane has since been taking care of her single-handedly, Aoi wants to move to Tokyo after her graduation to relieve her sister's burden and pursue a musical career, inspired by Akane's ex-boyfriend Shinnosuke \" Shinno \" Kanamuro. Shinno was part of a band until he left for Tokyo to become a professional bassist after the sisters' parents passed away. One afternoon, while Aoi practices her guitar in a guest house, she gets startled by the 18-year-old version of Shinno from 13 years ago! As if by coincidence, the current 31-year-old Shinno also returns to the town, but he has changed drastically. There are now two Shinno's in existence, but why is the Shinno from the past present? The story revolves around these four individuals as they confront their inner feelings toward each other and make decisions that will affect their lives from here on out.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/c4hBgtsekgjeB4ywfhWkDjb5sh2.jpg",
                        false
                )
        )
        movies.add(
                MovieEntity(
                        635302,
                        "Demon Slayer the Movie: Mugen Train (2020)",
                        "01/06/2021 (ID)",
                        "Animation, Action, Adventure, Fantasy, Drama",
                        "1h 57m",
                        "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
                        false
                )
        )
        movies.add(
                MovieEntity(
                        802699,
                        "The Girl from the Other Side (2022)",
                        "03/10/2022 (JP)",
                        "Animation, Drama, Mystery, Fantasy",
                        "1h",
                        "Once upon a time, in a far, faraway place, there were two lands. The world was divided into an inner land and an outer land. People feared the outer land, inhabited by eerie beings, the carriers of curse. One day, on the border to the inner land inhabited by humans, one such being finds a girl on heaps of abandoned dead bodies.The girl says her name is Shiva and shows affection to the \"being\" who found her, calling him \"Teacher.\" This is a story of two people—one human, one inhuman—who linger in the hazy twilight that separates night from day.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/rxu2MgncYDe6CGSASAwIaC4SHbR.jpg",
                        false
                )
        )
        return movies
    }

    fun generateDummyTvShows(): List<TvShowEntity> {
        val tvshows = ArrayList<TvShowEntity>()
        tvshows.add(
                TvShowEntity(
                        30983,
                        "Case Closed (1996)",
                        "Animation, Comedy, Mystery",
                        "1058 Episodes",
                        "25m",
                        "The son of a world famous mystery writer, Jimmy Kudo, has achieved his own notoriety by assisting the local police as a student detective. He has always been able to solve the most difficult of criminal cases using his wits and power of reason.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/9ve6LW4ltMMpp9WjoR4MGViOp9V.jpg",
                        false
                )
        )
        tvshows.add(
                TvShowEntity(
                        62450,
                        "Plastic Memories (2015)",
                        "Animation, Drama, Sci-Fi & Fantasy",
                        "13 Episodes",
                        "24m",
                        "After failing his college entrance exams, 18 year-old Tsukasa Mizugaki is offered a position at the renowned SAI Corporation, known for its production and management of Giftia, androids that possess human emotions. Tsukasa’s position is in the terminal service department where the main job is to recover Giftias that are close to their expiration, a graveyard department in every sense. To make matters worse, Tsukasa is ordered to work with Isla, a female Giftia who is never given any responsibility other than serving tea to co-workers.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/omOgvHRgfdWku75Gd8YSk2n0pX1.jpg",
                        false
                )
        )
        tvshows.add(
                TvShowEntity(
                        66256,
                        "Love in the Moonlight (2016)",
                        "Comedy, Drama, War & Politics",
                        "18 Episodes",
                        "1h",
                        "Hong Ra On, disguises herself as a man and counsels men on dating. Due to a love letter she wrote for a client, she meets Lee Young - future Crown Prince Hyomyeong. Hong Ra On is unaware that he is the Crown Prince and Lee Young is unaware that Hong Ra On is a woman. The Crown Prince becomes interested in Hong Ra On. His eunuchs become aware of this and attempt to get Hong Ra On to become one of them.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/qKir5S1ka8UkWVo8aGW9T19IIHC.jpg",
                        false
                )
        )
        tvshows.add(
                TvShowEntity(
                        66433,
                        "Scarlet Heart: Ryeo (2016)",
                        "Drama, Sci-Fi & Fantasy, War & Politics",
                        "20 Episodes",
                        "1h",
                        "When a total eclipse of the sun takes place, a 21st-century woman, Go Ha-jin, is transported back in time to the Goryeo Dynasty of Korea. She wakes up in the body of Hae-soo, an aristocrat living with Lady Hae, her cousin who happens to be married to one of the sons of King Taejo. She soon befriends several of the princes, who find her carefree and exuberant attitude refreshing. Although she knows she should not get involved in palace intrigues over the succession to the throne, she inadvertently becomes a pawn in the struggle, as several of the princes fall in love with her.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/pjdPGHqUe60ZGQJR1TItVNaV4it.jpg",
                        false
                )
        )
        tvshows.add(
                TvShowEntity(
                        67395,
                        "Tokyo Ravens (2013)",
                        "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy",
                        "24 Episodes",
                        "24m",
                        "Tsuchimikado Harutora was born into a prestigious Onmyoji family, but he can't see \"spirit energy\". Therefore, he's been enjoying a peaceful daily life with his friends at an Onmyo branch school. One day, his childhood friend Tsuchimikado Natsume, heir to the head family, suddenly appears. Will this cause his destiny spring into motion!?",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/zgCoBUFzK89BdWV3xh8oqw0PGGU.jpg",
                        false
                )
        )
        tvshows.add(
                TvShowEntity(
                        75214,
                        "Violet Evergarden (2018)",
                        "Animation, Sci-Fi & Fantasy, Drama",
                        "13 Episodes",
                        "25m",
                        "The Great War finally came to an end after four long years of conflict; fractured in two, the continent of Telesis slowly began to flourish once again. Caught up in the bloodshed was Violet Evergarden, a young girl raised for the sole purpose of decimating enemy lines. Hospitalized and maimed in a bloody skirmish during the War's final leg, she was left with only words from the person she held dearest, but with no understanding of their meaning. Recovering from her wounds, Violet starts a new life working at CH Postal Services after a falling out with her new intended guardian family. There, she witnesses by pure chance the work of an \"Auto Memoir Doll,\" amanuenses that transcribe people's thoughts and feelings into words on paper. Moved by the notion, Violet begins work as an Auto Memoir Doll, a trade that will take her on an adventure, one that will reshape the lives of her clients and hopefully lead to self-discovery.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/ImvHbM4GsJJykarnOzhtpG6ax6.jpg",
                        false
                )
        )
        tvshows.add(
                TvShowEntity(
                        90181,
                        "Class of Lies (2019)",
                        "Crime",
                        "16 Episodes",
                        "1h 10m",
                        "Ki Moo-Hyeok, a lawyer with a high winning rate, only cares about money. Due to a murder case at a high school which he deals with, his reputation as a lawyer hits rock bottom. To regain his good name as a lawyer, he sneaks into the high school and work as a temporary teacher. He tries to reveal a secret which the students have, and gets involved with Teacher Ha So-Hyun, a P.E. teacher who loves her students. They then face the students'secret.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/j57pZCKyaXRParhXE18hDGJRfbA.jpg",
                        false
                )
        )
        tvshows.add(
                TvShowEntity(
                        100281,
                        "Moriarty the Patriot (2020)",
                        "Animation, Mystery",
                        "24 Episodes",
                        "24m",
                        "In the late 19th century, the British Empire nobility reigns while its working class suffers at their hands. Sympathetic to their plight, William James Moriarty wants to topple it all. Frustrated by the systemic inequity, Moriarty strategizes to fix the entire nation. Not even consulting detective Sherlock Holmes can stand in his way. It’s time for crime to revolutionize the world!",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/mlCBLiXF2ioQl4Hq3ymUuiCLN2h.jpg",
                        false
                )
        )
        tvshows.add(
                TvShowEntity(
                        110070,
                        "Horimiya (2021)",
                        "Animation, Comedy",
                        "13 Episodes",
                        "24m",
                        "A secret life is the one thing they have in common. At school, Hori is a prim and perfect social butterfly, but the truth is she’s a brash homebody. Meanwhile, under a gloomy facade, Miyamura hides a gentle heart, along with piercings and tattoos. In a chance meeting, they both reveal a side they’ve never shown. Could this blossom into something new?",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/917VL7zHTaltnEBDrKWVITTsvLy.jpg",
                        false
                )
        )
        tvshows.add(
                TvShowEntity(
                        117378,
                        "Mouse (2021)",
                        "Crime, Mystery",
                        "22 Episodes",
                        "1h 16m",
                        "A psychopath’s ruthless serial murders have left the entire nation gripped with fear and chaos. A honest and justice-seeking rookie police officer and a veteran detective with tragic past, face against the killer. After the encounter with the psychopath, their lives totally change.",
                        "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/5TzlR5waz77q3AQm5VuMHAYvRgE.jpg",
                        false
                )
        )
        tvshows.add(
                TvShowEntity(
                        118895,
                        "Kingdom: Legendary War (2021)",
                        "Reality",
                        "4 Episodes",
                        "1h 30m",
                        "THE BOYZ, who were the final winners on the preliminary show “Road to Kingdom,” will be competing on “Kingdom” along with Stray Kids, ATEEZ, BTOB 4U, iKON, and SF9.",
                        "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/zOfW0Ljkdy8VwSc8mUWuYAG8xq1.jpg",
                        false
                )
        )
        tvshows.add(
                TvShowEntity(
                        119773,
                        "Law School (2021)",
                        "Drama",
                        "16 Episodes",
                        "1h",
                        "“Law School” is about the students and professors of South Korea’s top law school who get caught up in an unusual case.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/ePKPXlfUtrJAsyW7EuNlfcYnvHM.jpg",
                        false
                )
        )
        return tvshows
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()
        movies.add(
                MovieResponse(
                        58107,
                        "Black★Rock Shooter (2010)",
                        "07/07/2010 (JP)",
                        "Drama, Animation, Fantasy",
                        "52m",
                        "The story of two girls bound in friendship, as well as Black Rock Star's struggle unfolding in another world. But when the two worlds come together... what will happen?",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/tc2I5OQqDr13WF178I3C0rCX9iu.jpg",
                        false
                )
        )
        movies.add(
                MovieResponse(
                        504253,
                        "I Want to Eat Your Pancreas (2018)",
                        "09/01/2018 (JP)",
                        "Animation, Drama, Romance, Family",
                        "1h 48m",
                        "Spring time in April and the last of the cherry blossoms are still in bloom. The usually aloof bookworm with no interest in others comes across a book in a hospital waiting room. Handwritten on the cover are the words: \"Living with Dying.\" He soon discovers that it is a diary kept by his very popular and genuinely cheerful classmate, Sakura Yamauchi, who reveals to him that she is secretly suffering from a pancreatic illness and only has a limited time left. It is at this moment that she gains just one more person to share her secret. Trying to maintain a normal life as much as possible, Sakura is determined to live her life to the fullest until the very last day. As her free spirit and unpredictable actions throw him for a loop, his heart begins to gradually change.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/vHdVU0HyyB6k6kuYt8qjwTz9one.jpg",
                        false
                )
        )
        movies.add(
                MovieResponse(
                        372058,
                        "Your Name (2016)",
                        "08/26/2016 (JP)",
                        "Romance, Animation, Drama",
                        "1h 46m",
                        "High schoolers Mitsuha and Taki are complete strangers living separate lives. But one night, they suddenly switch places. Mitsuha wakes up in Taki’s body, and he in hers. This bizarre occurrence continues to happen randomly, and the two must adjust their lives around each other.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/q719jXXEzOoYaps6babgKnONONX.jpg",
                        false
                )
        )
        movies.add(
                MovieResponse(
                        378064,
                        "A Silent Voice: The Movie (2016)",
                        "09/17/2016 (JP)",
                        "Animation, Drama, Romance",
                        "2h 10m",
                        "Shouya Ishida starts bullying the new girl in class, Shouko Nishimiya, because she is deaf. But as the teasing continues, the rest of the class starts to turn on Shouya for his lack of compassion. When they leave elementary school, Shouko and Shouya do not speak to each other again... until an older, wiser Shouya, tormented by his past behaviour, decides he must see Shouko once more. He wants to atone for his sins, but is it already too late...?",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/tuFaWiqX0TXoWu7DGNcmX3UW7sT.jpg",
                        false
                )
        )
        movies.add(
                MovieResponse(
                        412383,
                        "Fleet Girls Collection KanColle Movie Sequence (2016)",
                        "11/26/2016 (JP)",
                        "Animation, Science Fiction, War, Action",
                        "1h 33m",
                        "The staff at the \"Dai-Ni-Kai \'KanColle\' Kankanshiki\" event in Yokohama in August 2015 announced that the Kantai Collection franchise will get an anime film in 2016. The event screened footage that features the Kan-musume characters Fubuki, Mutsuki, Yuudachi, Akagi and Kaga, Hiryuu Kaini and Souryuu Kaini, the four Kongou sisters (Kaini), Kitakami and Ooi, Choukai Kaini, Yuubari, Mutsu and Nagato, Kako Kaini and Furutaka Kaini, Zuikaku and Shoukaku, Shimakaze, Kuma, and Ouyodo. ",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/grjoz79lPmeljxxipUgE8mzvXIG.jpg",
                        false
                )
        )
        movies.add(
                MovieResponse(
                        482150,
                        "Liz and the Blue Bird (2018)",
                        "04/21/2018 (JP)",
                        "Animation, Drama, Music",
                        "1h 30m",
                        "Two girls grow closer as they practice for their last duet before graduating, a piece called \"Liz And The Blue Bird\".",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/7xRIkqWJy4cNpUxPo5aZ24O0Tyx.jpg",
                        false
                )
        )
        movies.add(
                MovieResponse(
                        528225,
                        "Sound! Euphonium the Movie - Our Promise: A Brand New Day (2019)",
                        "04/19/2019 (JP)",
                        "Animation, Drama",
                        "1h 40m",
                        "Kumiko is now a second year and one of the senior players of the euphonium section. With new underclassmen joining the concert band, Kumiko will have to learn new things in order to deal with awkward and difficult underclassmen. She and third-year trumpeter Tomoe Kabe have been chosen to lead the new underclassmen members. Among the new members to Kumiko's bass section are euphonist Kanade Hisaishi, whose appearances are deceiving; tuba player Mirei Suzuki, who cannot adapt to her new environment; tuba player Satsuki Suzuki, who wants to get along with Mirei; and double bassist Motomu Tsukinaga, who cannot talk about himself. Between the Sunrise Festival, chair placement auditions, and the competition, a number of problems quickly begin to arise.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/azIvdBzPlFUkY5TCFhgXcUZLq5f.jpg",
                        false
                )
        )
        movies.add(
                MovieResponse(
                        533514,
                        "Violet Evergarden: The Movie (2020)",
                        "03/03/2021 (ID)",
                        "Animation, Drama, Romance, Fantasy",
                        "2h 20m",
                        "After working as an Auto Memory Doll, Violet Evergarden has come to learn the meaning of the words \"I love you.\" Her soul, which has been deeply scarred by the war, has begun to heal. She continues to move forward in life, helping others in need, while keeping the words of the first person who ever said \"I love you\" to her close to her heart. When she takes on a job to write a letter for a terminally-ill boy, time starts to move forward.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/fwSonK8WrAEqWY7sqjvGRCgzIij.jpg",
                        false
                )
        )
        movies.add(
                MovieResponse(
                        615165,
                        "Her Blue Sky (2019)",
                        "03/11/2020 (ID)",
                        "Animation, Romance",
                        "1h 48m",
                        "High school student Aoi lives with her elder sister, Akane, after a tragic accident took their parents away 13 years ago. Because Akane has since been taking care of her single-handedly, Aoi wants to move to Tokyo after her graduation to relieve her sister's burden and pursue a musical career, inspired by Akane's ex-boyfriend Shinnosuke \" Shinno \" Kanamuro. Shinno was part of a band until he left for Tokyo to become a professional bassist after the sisters' parents passed away. One afternoon, while Aoi practices her guitar in a guest house, she gets startled by the 18-year-old version of Shinno from 13 years ago! As if by coincidence, the current 31-year-old Shinno also returns to the town, but he has changed drastically. There are now two Shinno's in existence, but why is the Shinno from the past present? The story revolves around these four individuals as they confront their inner feelings toward each other and make decisions that will affect their lives from here on out.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/c4hBgtsekgjeB4ywfhWkDjb5sh2.jpg",
                        false
                )
        )
        movies.add(
                MovieResponse(
                        635302,
                        "Demon Slayer the Movie: Mugen Train (2020)",
                        "01/06/2021 (ID)",
                        "Animation, Action, Adventure, Fantasy, Drama",
                        "1h 57m",
                        "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
                        false
                )
        )
        movies.add(
                MovieResponse(
                        802699,
                        "The Girl from the Other Side (2022)",
                        "03/10/2022 (JP)",
                        "Animation, Drama, Mystery, Fantasy",
                        "1h",
                        "Once upon a time, in a far, faraway place, there were two lands. The world was divided into an inner land and an outer land. People feared the outer land, inhabited by eerie beings, the carriers of curse. One day, on the border to the inner land inhabited by humans, one such being finds a girl on heaps of abandoned dead bodies.The girl says her name is Shiva and shows affection to the \"being\" who found her, calling him \"Teacher.\" This is a story of two people—one human, one inhuman—who linger in the hazy twilight that separates night from day.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/rxu2MgncYDe6CGSASAwIaC4SHbR.jpg",
                        false
                )
        )
        return movies
    }

    fun generateRemoteDummyTvShows(): List<TvShowResponse> {
        val tvshows = ArrayList<TvShowResponse>()
        tvshows.add(
                TvShowResponse(
                        30983,
                        "Case Closed (1996)",
                        "Animation, Comedy, Mystery",
                        "1058 Episodes",
                        "25m",
                        "The son of a world famous mystery writer, Jimmy Kudo, has achieved his own notoriety by assisting the local police as a student detective. He has always been able to solve the most difficult of criminal cases using his wits and power of reason.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/9ve6LW4ltMMpp9WjoR4MGViOp9V.jpg",
                        false
                )
        )
        tvshows.add(
                TvShowResponse(
                        62450,
                        "Plastic Memories (2015)",
                        "Animation, Drama, Sci-Fi & Fantasy",
                        "13 Episodes",
                        "24m",
                        "After failing his college entrance exams, 18 year-old Tsukasa Mizugaki is offered a position at the renowned SAI Corporation, known for its production and management of Giftia, androids that possess human emotions. Tsukasa’s position is in the terminal service department where the main job is to recover Giftias that are close to their expiration, a graveyard department in every sense. To make matters worse, Tsukasa is ordered to work with Isla, a female Giftia who is never given any responsibility other than serving tea to co-workers.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/omOgvHRgfdWku75Gd8YSk2n0pX1.jpg",
                        false
                )
        )
        tvshows.add(
                TvShowResponse(
                        66256,
                        "Love in the Moonlight (2016)",
                        "Comedy, Drama, War & Politics",
                        "18 Episodes",
                        "1h",
                        "Hong Ra On, disguises herself as a man and counsels men on dating. Due to a love letter she wrote for a client, she meets Lee Young - future Crown Prince Hyomyeong. Hong Ra On is unaware that he is the Crown Prince and Lee Young is unaware that Hong Ra On is a woman. The Crown Prince becomes interested in Hong Ra On. His eunuchs become aware of this and attempt to get Hong Ra On to become one of them.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/qKir5S1ka8UkWVo8aGW9T19IIHC.jpg",
                        false
                )
        )
        tvshows.add(
                TvShowResponse(
                        66433,
                        "Scarlet Heart: Ryeo (2016)",
                        "Drama, Sci-Fi & Fantasy, War & Politics",
                        "20 Episodes",
                        "1h",
                        "When a total eclipse of the sun takes place, a 21st-century woman, Go Ha-jin, is transported back in time to the Goryeo Dynasty of Korea. She wakes up in the body of Hae-soo, an aristocrat living with Lady Hae, her cousin who happens to be married to one of the sons of King Taejo. She soon befriends several of the princes, who find her carefree and exuberant attitude refreshing. Although she knows she should not get involved in palace intrigues over the succession to the throne, she inadvertently becomes a pawn in the struggle, as several of the princes fall in love with her.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/pjdPGHqUe60ZGQJR1TItVNaV4it.jpg",
                        false
                )
        )
        tvshows.add(
                TvShowResponse(
                        67395,
                        "Tokyo Ravens (2013)",
                        "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy",
                        "24 Episodes",
                        "24m",
                        "Tsuchimikado Harutora was born into a prestigious Onmyoji family, but he can't see \"spirit energy\". Therefore, he's been enjoying a peaceful daily life with his friends at an Onmyo branch school. One day, his childhood friend Tsuchimikado Natsume, heir to the head family, suddenly appears. Will this cause his destiny spring into motion!?",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/zgCoBUFzK89BdWV3xh8oqw0PGGU.jpg",
                        false
                )
        )
        tvshows.add(
                TvShowResponse(
                        75214,
                        "Violet Evergarden (2018)",
                        "Animation, Sci-Fi & Fantasy, Drama",
                        "13 Episodes",
                        "25m",
                        "The Great War finally came to an end after four long years of conflict; fractured in two, the continent of Telesis slowly began to flourish once again. Caught up in the bloodshed was Violet Evergarden, a young girl raised for the sole purpose of decimating enemy lines. Hospitalized and maimed in a bloody skirmish during the War's final leg, she was left with only words from the person she held dearest, but with no understanding of their meaning. Recovering from her wounds, Violet starts a new life working at CH Postal Services after a falling out with her new intended guardian family. There, she witnesses by pure chance the work of an \"Auto Memoir Doll,\" amanuenses that transcribe people's thoughts and feelings into words on paper. Moved by the notion, Violet begins work as an Auto Memoir Doll, a trade that will take her on an adventure, one that will reshape the lives of her clients and hopefully lead to self-discovery.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/ImvHbM4GsJJykarnOzhtpG6ax6.jpg",
                        false
                )
        )
        tvshows.add(
                TvShowResponse(
                        90181,
                        "Class of Lies (2019)",
                        "Crime",
                        "16 Episodes",
                        "1h 10m",
                        "Ki Moo-Hyeok, a lawyer with a high winning rate, only cares about money. Due to a murder case at a high school which he deals with, his reputation as a lawyer hits rock bottom. To regain his good name as a lawyer, he sneaks into the high school and work as a temporary teacher. He tries to reveal a secret which the students have, and gets involved with Teacher Ha So-Hyun, a P.E. teacher who loves her students. They then face the students'secret.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/j57pZCKyaXRParhXE18hDGJRfbA.jpg",
                        false
                )
        )
        tvshows.add(
                TvShowResponse(
                        100281,
                        "Moriarty the Patriot (2020)",
                        "Animation, Mystery",
                        "24 Episodes",
                        "24m",
                        "In the late 19th century, the British Empire nobility reigns while its working class suffers at their hands. Sympathetic to their plight, William James Moriarty wants to topple it all. Frustrated by the systemic inequity, Moriarty strategizes to fix the entire nation. Not even consulting detective Sherlock Holmes can stand in his way. It’s time for crime to revolutionize the world!",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/mlCBLiXF2ioQl4Hq3ymUuiCLN2h.jpg",
                        false
                )
        )
        tvshows.add(
                TvShowResponse(
                        110070,
                        "Horimiya (2021)",
                        "Animation, Comedy",
                        "13 Episodes",
                        "24m",
                        "A secret life is the one thing they have in common. At school, Hori is a prim and perfect social butterfly, but the truth is she’s a brash homebody. Meanwhile, under a gloomy facade, Miyamura hides a gentle heart, along with piercings and tattoos. In a chance meeting, they both reveal a side they’ve never shown. Could this blossom into something new?",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/917VL7zHTaltnEBDrKWVITTsvLy.jpg",
                        false
                )
        )
        tvshows.add(
                TvShowResponse(
                        117378,
                        "Mouse (2021)",
                        "Crime, Mystery",
                        "22 Episodes",
                        "1h 16m",
                        "A psychopath’s ruthless serial murders have left the entire nation gripped with fear and chaos. A honest and justice-seeking rookie police officer and a veteran detective with tragic past, face against the killer. After the encounter with the psychopath, their lives totally change.",
                        "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/5TzlR5waz77q3AQm5VuMHAYvRgE.jpg",
                        false
                )
        )
        tvshows.add(
                TvShowResponse(
                        118895,
                        "Kingdom: Legendary War (2021)",
                        "Reality",
                        "4 Episodes",
                        "1h 30m",
                        "THE BOYZ, who were the final winners on the preliminary show “Road to Kingdom,” will be competing on “Kingdom” along with Stray Kids, ATEEZ, BTOB 4U, iKON, and SF9.",
                        "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/zOfW0Ljkdy8VwSc8mUWuYAG8xq1.jpg",
                        false
                )
        )
        tvshows.add(
                TvShowResponse(
                        119773,
                        "Law School (2021)",
                        "Drama",
                        "16 Episodes",
                        "1h",
                        "“Law School” is about the students and professors of South Korea’s top law school who get caught up in an unusual case.",
                        "https://www.themoviedb.org/t/p/w220_and_h330_face/ePKPXlfUtrJAsyW7EuNlfcYnvHM.jpg",
                        false
                )
        )
        return tvshows
    }
}