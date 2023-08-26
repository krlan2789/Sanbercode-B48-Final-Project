package com.lan.sanbercodefinalproject.datasource

import com.lan.sanbercodefinalproject.model.ArticleModel

object ArticleDataSource {
    fun loadArticles(): List<ArticleModel> {
        return listOf(
            ArticleModel(author = "Erlan K", datePublished = "2023-08-23 19:02:19", description = "", imageUrl = "https://resources.premierleague.com/photos/2023/08/23/6f2cb1ee-30a9-4e04-a5ac-20ffaec2f66f/fpl-diffs-MW3.jpg?width=1400&height=800", title = "Juventus, berhenti dengan rasa hamletik", category = "Transfer"),
            ArticleModel(author = "Erlan K", datePublished = "2023-08-23 03:29:13", description = "", imageUrl = "https://resources.premierleague.com/photos/2023/08/19/bca867ae-9619-412f-bd68-72ca25f39a5e/1625751849.jpg?width=1400&height=800", title = "Manchester City vs Newcastle United: Matches preview", category = "Matches Preview"),
            ArticleModel(author = "Erlan K", datePublished = "2023-08-22 20:49:53", description = "", imageUrl = "https://resources.premierleague.com/photos/2023/08/22/05f2fb3c-0096-4b96-b539-f638bcf633a0/FPL-OTW-MW3-NEW.jpg?width=1400&height=800", title = "Tottenham Hotspur vs Manchester United: Matches preview", category = "Matches Preview"),
            ArticleModel(author = "Erlan K", datePublished = "2023-08-20 07:41:25", description = "", imageUrl = "https://resources.premierleague.com/photos/2023/08/21/1f41e18f-9456-4dc8-8f3f-b9bd33a2f97f/March-Brighton.jpg?width=1400&height=800", title = "LALIGA dan Asosiasi Sepak Bola Irak (IFA) telah memulai kerjasamanya, bagian dari proyek tiga tahun", category = "Outfield"),
            ArticleModel(author = "Erlan K", datePublished = "2023-08-20 09:21:09", description = "", imageUrl = "https://resources.premierleague.com/photos/2023/07/25/cd45e7cf-0985-41b6-a9cc-3ad75c380e7a/Ella-PL-Inspires.jpg?width=1400&height=800", title = "Ella's story: PL Inspires has given me tools to fight my anxiety", category = "Outfield"),
            ArticleModel(author = "Erlan K", datePublished = "2023-08-17 22:39:56", description = "", imageUrl = "https://resources.premierleague.com/photos/2023/08/23/fe131799-8640-483f-855d-1e40ef5988d4/Screenshot-2023-08-23-at-18.23.25.png?width=1400&height=800", title = "Bernardo Silva signs Man City contract extension", category = "Transfer"),
        )
    }
}