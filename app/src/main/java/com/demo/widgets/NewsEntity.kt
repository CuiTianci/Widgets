package com.demo.widgets

import androidx.annotation.DrawableRes

data class NewsEntity(
    @DrawableRes val imageId: Int,
    val title: String,
    val content: String,
)

val newsList = listOf(
    NewsEntity(
        R.drawable.putin,
        "Putin signs decree allowing foreigners to swap frozen funds for blocked Russian assets abroad",
        """
            MOSCOW (Reuters) - Russia's President Vladimir Putin signed a decree on Wednesday allowing foreign investors with funds frozen in Russia to use them to buy blocked assets of Russians abroad.

            As a result of sanctions imposed by the West over Russia's actions in Ukraine, more than 3.5 million Russians have frozen assets abroad worth around 1.5 trillion roubles (${'$'}16.3 billion).

            Under the decree, Russia will allow citizens of what it deems "unfriendly" countries to buy frozen securities held abroad by Russians by using funds from special "type-C" accounts in Russia, which are otherwise effectively blocked.

            Russia plans to unblock accounts worth about 100 billion roubles in the first phase.

            The text of Putin's decree says it is being issued in response to actions by the United States and other countries and organisations that it calls "unfriendly and contradictory to international law".

            (${'$'}1 = 91.8080 roubles)

            (Reporting by Elena Fabrichnaya and Mark Trevelyan; Editing by Andrew Cawthorne)
        """.trimIndent(),
    ),
    NewsEntity(
        R.drawable.fact_check,
        "Fact Check: Cracker Barrel Old Country Store Is Closing All Locations, as Announced in 2023?",
        """
            Claim:

            An online advertisement displayed in November 2023 said that Cracker Barrel Old Country Store planned to close some or all of its locations.

            In October and November 2023, hundreds of different online advertisements were displayed to users on Facebook and Instagram that each showed a photo of a Cracker Barrel Old Country Store restaurant location. The caption of most of the ads read, "Closing Time: All The Restaurant Chains Closing."

            The ads appeared to hint that Cracker Barrel would be closing some or all of its locations, going bankrupt or going out of business for other reasons.

            These are just two of the many examples of what the ads looked like.

            All of the ads led to an article on the Investing.com website. The headline of the article read, "Last Call: These Chain Stores Are Closing Locations in 2023."

            The article listed 216 different businesses, most that appeared to be American brands. Under each business name were several paragraphs describing whether the companies would be closing some or all of its locations. In other words, the article was massive in its length.

            In other words, the Facebook and Instagram ads were clickbait and the rumor that Cracker Barrel was closing was false, as we noted with our fact-check rating at the top of this story. The clickbait ads led users to the massive article that required a seemingly endless amount of scrolling and reading in order to find anything about whether Cracker Barrel was closing.

            The reason why these kinds of ads and articles exist is usually for something called advertising arbitrage. Advertising arbitrage is a strategy in which an advertiser hopes to make more money on ads displayed in a lengthy article than it would cost to display an initial clickbait ad meant to attract users to the article.

            We contacted Cracker Barrel to inquire about the possibility of any future restaurant closures. By email, a spokesperson for the company told us, "At this time, we do not have any store closures planned. We remain fully committed to serving our guests and communities in our more than 660 stores across 45 states."
        """.trimIndent(),
    ),
    NewsEntity(
        R.drawable.ocean,
        "Orcas strike back (again), sinking another yacht in Europe after 45-minute attack",
        """
            Orcas strike back (again), sinking another yacht in Europe after 45-minute attack

            Sailors’ newest nightmare has struck again, and on Halloween of all days.

            A pod of orcas in southwestern Europe sank a sailing boat on Oct. 31 after a non-stop, 45-minute attack, Live Science reported.  The incident is the fourth occurrence  in two years where orcas, also known as killer whales, are blamed for sinking ships in southwestern Europe.

            Orca pods from the Strait of Gibraltar region have been harassing boats and their passengers for more than three years.

            According to a translated Facebook post made by Polish cruise company Morskie Mile, owner of the sunken boat, a mid-size sailing yacht named the Grazie Mamma was attacked by a pod of orcas off the coast of Morocco in the Strait of Gibraltar. Major damage caused by an unknown number of orcas who repeatedly hit the yacht's rudder caused water to enter the vessel's hull.  All passengers were safely evacuated before the boat sank as it entered the port of Tanger-Med in Morocco while in tow with the Moroccan Navy.

            Experts gathered earlier this year to try and address "urgent need for specific actions based on  international coordination between  administrations, mariners and scientists  to prevent future damage to  people, orcas and vessels," GTOA said.

            Andrew Trites, professor and director of Marine Mammal Research at the University of British Columbia, told CBS News that there are two main theories about why this is happening, but for now it remains to be an “unprecedented” mystery. Trites said something is positively reinforcing the behavior among the highly intelligent species.

            Iberian orcas are the only species of whale that have been known to attack boats in this region, Trites added.

            The first main theory is that orcas are engaging in a type of whale "play" or "sport,” Trites said. The second theory is that orcas’ years of dealing with traumatic boating injuries have resulted in a "negative experience.”

            Whale expert Anne Gordon told USA Today that these are isolated incidents.

            "Yes, their job is to be predators in the ocean, but in normal circumstances there is absolutely zero threat to humans in a boat," Gordon said.

            “I think it gets taken as aggression because it’s causing damage, but I don’t think we can say that the motivation is aggressive necessarily,” Monika Wieland Shields, director of the Washington based nonprofit research organization Orca Behavior Institute, told NBC News late last month.

            This article originally appeared on USA TODAY: Orcas, or killer whales, blamed for attack sinking sailboat in Europe
        """.trimIndent(),
    ),
    NewsEntity(
        R.drawable.russian,
        "Russia's Lavrov assails West over switch to green energy",
        """
            MOSCOW (Reuters) - Russian Foreign Minister Sergei Lavrov accused the West on Wednesday of provoking crises on the global oil and gas market by rushing to switch to green energy and imposing pressure on other countries to do the same.

            "In fact, the reasons for the negative phenomena in the energy sector were the irresponsible actions of the collective West, when it decided to force ... the green transition for itself and impose the same green transition on other countries that were simply not economically ready for it," Lavrov said in televised comments.

            He said Western boycotts of Russian energy in response to the war in Ukraine had "dealt a serious blow to global energy security. These steps led to the rupture of historical value chains, costly redistribution of global energy flows and rising transaction and logistics costs."

            Lavrov said the blowing-up of Russia's Nord Stream gas pipelines to Europe last year had deprived the continent of cheap gas and made it more reliant on expensive imports from the United States.

            His comments were in line with Moscow's long-running narrative that sanctions against Russia have been an own goal, and that Western countries have made a grave mistake in turning away from Russian energy.

            The sanctions have severely hit Russian gas giant Gazprom, which has lost most of its European markets, and forced Russia to sharply increase sales of oil at discounted prices to countries such as China and India.

            (Reporting by Reuters; Editing by Gareth Jones)
        """.trimIndent(),
    ),
    NewsEntity(
        R.drawable.oleary,
        "'What are you, an idiot?': Kevin O’Leary says people are wasting 15 to 20% of their income on ‘stupid stuff’ like coffee and sandwiches — here’s what he wants you to do instead",
        """
            Swinging by your local coffee shop for a little caffeine boost before your work day commences might feel like an absolutely unskippable step in your morning ritual — but Shark Tank star Kevin O’Leary says it’s little purchases like these that push people into debt.

            “Stop buying coffee for ${'$'}5.50,” O’Leary said on an episode of the Erika Taught Me podcast, hosted by lawyer and money influencer Erika Kullberg.

            Don’t miss
            Commercial real estate has outperformed the S&P 500 over 25 years. Here's how to diversify your portfolio without the headache of being a landlord

            Rich young Americans have lost confidence in the stock market — and are betting on these 3 assets instead. Get in now for strong long-term tailwinds

            'A natural way to diversify': Janet Yellen now says Americans should expect a decline in the USD as the world's reserve currency — 3 ways you can prepare

            “I can walk around with anybody for a day and tell you they’re wasting 15% of their money — sometimes 20% [on] stupid stuff.”

            Here are some of the veteran investor’s cold hard truths when it comes to spending money, and what he says you should do instead.

            Small everyday purchases can add up
            Inflation is hitting consumers hard and pushing even higher-income folks into a paycheck to paycheck lifestyle.

            Just take a look at food-away-from-home costs — which have climbed 6% since last year, according to the latest consumer price data. In comparison, food-at-home costs have only gone up by 2.4%.

            “You go to work, you spend ${'$'}15 on a sandwich. What are you, an idiot?” O’Leary said during the podcast, urging folks to make their own lunches and bring their coffee from home.

            “You start to add that up everyday, it’s a ton of money.”

            O’Leary isn’t wrong about people spending more when they go to work. A recent report from video-conferencing company Owl Labs found that workers spend about ${'$'}31 more each day when they work from the office compared to at home, and this could become an even more pressing problem with more companies doing away with their COVID-era remote work policies.

            O’Leary claims that a lot of Americans — especially those who work in big cities — are making their first ${'$'}60,000 in their early careers “piss away” about ${'$'}15,000 a year on unnecessary purchases.

            O’Leary’s mom taught him an important lesson
            O’Leary credits his mother, Georgette O’Leary, a small business owner, for teaching him how to manage money.

            Georgette advised him to never spend more than what he earned — and that’s a lesson Mr. Wonderful wants to share with Americans as well. He recommends folks write down their various sources of income and their expenses over a 90-day period.

            He says folks often end up spending more than they make and needing to dig themselves out of debt. A lot of spending is done on credit cards, which can come with interest rates of around 21%. In the second quarter of this year, Americans’ credit card balances hit a record high of ${'$'}1.03 trillion, according to the latest data from the New York Fed.

            “That’s what destroys people,” he cautions. “They just don’t live within their means.”

            Read more: Thanks to Jeff Bezos, you can now use ${'$'}100 to cash in on prime real estate — without the headache of being a landlord. Here's how

            What you should do instead
            O’Leary has a few tips for folks trying to figure out how to manage their money, which he discusses on Kullberg’s podcast.

            Firstly, he recommends you save about 20% of your income and invest it in the market over a 20 to 30 year period to get you a return of about 6-8% and help you retire with a solid nest egg.

            “Even if you have the average salary — ${'$'}54,00 in America — you’ll have a million and a half bucks in the bank,” he claims.

            O’Leary also tells people to be intentional with their purchases, recounting that Georgette used to buy just one really good Chanel jacket a year and when she died, family members fought over her clothing since they were vintage and their value had soared over time.

            “Don’t buy the crap, just buy the good stuff, and buy less of it,” he advises. Try to avoid purchasing a lot of cheap, fast fashion and opt for more sustainable, long-lasting pieces that will be better for the environment and your wallet.

            And don’t forget to reward yourself. O’Leary says you should never go into debt for something you can’t afford, but if you’ve got the funds feel free to treat yourself as a reminder that you’re doing well and hitting your financial goals.

            Lastly, O’Leary says if you want to make more money and have a good skill set, consider starting your own side hustle outside of your main job. He would know — after all, he’s seen plenty of folks bring their own business ideas to television shows like Shark Tank and Dragon’s Den.

            “I don’t believe in the 9-to-5 job market anymore,” he says. “We have people working for us all around the world, we somehow are very, very productive and that’s the new economy.”
        """.trimIndent(),
    ),
)
