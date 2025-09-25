package com.ekspensify.app.data.model


import com.ekspensify.app.R

data class IntroPages(
    val image: Int,
    val titleRes: Int,
    val descriptionRes: Int,
) {
    companion object {
        fun getPages(): List<IntroPages> {
            val pages = mutableListOf<IntroPages>()
            pages.add(
                IntroPages(
                    image = R.drawable.ic_onboarding_1,
                    titleRes = R.string.onboarding_title_1,
                    descriptionRes = R.string.onboarding_desc_1
                )
            )

            pages.add(
                IntroPages(
                    image = R.drawable.ic_onboarding_2,
                    titleRes = R.string.onboarding_title_2,
                    descriptionRes = R.string.onboarding_desc_2
                )
            )

            pages.add(
                IntroPages(
                    image = R.drawable.ic_onboarding_3,
                    titleRes = R.string.onboarding_title_3,
                    descriptionRes = R.string.onboarding_desc_3
                )
            )

            return pages
        }
    }
}