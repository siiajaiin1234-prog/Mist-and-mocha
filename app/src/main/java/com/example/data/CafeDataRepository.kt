package com.example.data

import com.example.R
import com.example.model.Article
import com.example.model.ArticleSection
import com.example.model.MenuItem
import com.example.model.PageMetadata

object CafeDataRepository {

    val articles: List<Article> = listOf(
        Article(
            id = "art-1",
            slug = "art-of-slow-pour-over-brewing",
            canonicalUrl = "https://mistandmocha.com/blog/art-of-slow-pour-over-brewing",
            // Title Rule: 1 main keyword (Pour-Over Coffee) + 2 related keywords (Manual Brewing, Extraction Ratios)
            title = "Pour-Over Coffee: Manual Brewing Secrets, Water Temp & Extraction Ratios",
            mainKeyword = "Pour-Over Coffee",
            relatedKeywords = listOf("Manual Brewing", "Extraction Ratios"),
            // Meta Description Rule: 140-160 chars, active voice, keywords included
            metaDescription = "Master pour-over coffee with our manual brewing guide to water temperature and extraction ratios. Unlock fragrant floral notes with Mist & Mocha baristas.",
            category = "Brewing Craft",
            author = "Elena Vance",
            authorRole = "Head Roaster & Q-Grader",
            datePublished = "October 10, 2026",
            readingTimeMinutes = 6,
            localDrawableRes = R.drawable.img_cafe_hero,
            imageUrl = "https://images.unsplash.com/photo-1514432324607-a09d9b4aefdd?auto=format&fit=crop&w=720&q=75",
            imageAlt = "Handcrafted pour-over coffee dripping through ceramic dripper with rising mist",
            imageSizeKb = 78,
            excerpt = "Unlocking the delicate jasmine and citrus notes of high-altitude beans requires deliberate flow dynamics and exact extraction ratios.",
            sections = listOf(
                ArticleSection(
                    heading = "The Philosophy of the Slow Pour",
                    isQuestionAnswer = false,
                    paragraphs = listOf(
                        "At Mist and Mocha, morning brewing is not a hasty utility—it is a sensory ritual. When hot water first touches freshly roasted grounds, carbon dioxide escapes in an effervescent bloom, releasing sweet aromatics that set the tone for your day.",
                        "Using manual brewing drippers like the Hario V60, Kalita Wave, or origami ceramic vessels allows you to control contact time, turbulence, and heat retention with surgical precision."
                    ),
                    anchorLinkText = "explore our single-origin bean menu",
                    anchorLinkUrl = "https://mistandmocha.com/menu"
                ),
                ArticleSection(
                    heading = "Why does water temperature matter for pour-over coffee?",
                    isQuestionAnswer = true,
                    paragraphs = listOf(
                        "Water temperature directly governs chemical solubility. Water between 92°C and 96°C (198°F–205°F) extracts desirable fruit acids and delicate sugars first, leaving heavy astringent tannins behind.",
                        "If your water is too boiling (above 98°C), you scorch the grounds and extract bitter chlorogenic acid derivatives. If it drops below 88°C, the brew ends up under-extracted, tasting hollow and sharply sour."
                    ),
                    baristaTip = "Always preheat your brewer and rinse paper filters with 100ml hot water to eliminate paper taste and maintain thermal stability."
                ),
                ArticleSection(
                    heading = "How should you calculate your extraction ratios for manual brewing?",
                    isQuestionAnswer = true,
                    paragraphs = listOf(
                        "We recommend a golden extraction ratio of 1:16 (coffee to water) for balanced origin expression. For every 15 grams of coffee, pour exactly 240 grams of filtered water.",
                        "If you crave a lighter, tea-like floral profile from washed Ethiopian coffees, push your ratio to 1:17. Conversely, if you prefer heavier body and caramelized sweetness from natural processed beans, tighten down to 1:15."
                    ),
                    anchorLinkText = "reserve a barista cupping workshop",
                    anchorLinkUrl = "https://mistandmocha.com/reserve"
                ),
                ArticleSection(
                    heading = "The Four-Stage Pouring Protocol",
                    isQuestionAnswer = false,
                    paragraphs = listOf(
                        "Stage 1: The Bloom (0:00 - 0:45) - Pour 45g of water in a gentle spiral. Let the coffee bed swell and degassing cease.",
                        "Stage 2: The Core Extraction (0:45 - 1:30) - Pour steadily to 140g, maintaining a continuous stream without washing grounds up the wall.",
                        "Stage 3: The Balancing Pour (1:30 - 2:15) - Pour outward in concentric circles up to 240g.",
                        "Stage 4: The Final Drawdown (2:15 - 3:00) - Allow gravity to filter the nectar through the flat bed of grounds."
                    ),
                    anchorLinkText = "read our roast curve analysis",
                    anchorLinkUrl = "https://mistandmocha.com/blog/science-of-coffee-roasting-first-crack"
                )
            ),
            tags = listOf("Pour-Over", "V60", "Barista Science", "Single-Origin")
        ),

        Article(
            id = "art-2",
            slug = "ethiopian-yirgacheffe-origin-guide",
            canonicalUrl = "https://mistandmocha.com/blog/ethiopian-yirgacheffe-origin-guide",
            title = "Single-Origin Coffee: Heirloom Varietals, Wet Processing & Yirgacheffe Terroir",
            mainKeyword = "Single-Origin Coffee",
            relatedKeywords = listOf("Heirloom Varietals", "Wet Processing"),
            metaDescription = "Explore single-origin coffee from Ethiopian Yirgacheffe. Learn how heirloom varietals and wet processing create tea-like jasmine and bergamot cup notes.",
            category = "Origin & Terroir",
            author = "Marcus Thorne",
            authorRole = "Green Coffee Buyer",
            datePublished = "October 8, 2026",
            readingTimeMinutes = 5,
            localDrawableRes = R.drawable.img_latte_art,
            imageUrl = "https://images.unsplash.com/photo-1511920170033-f8396924c348?auto=format&fit=crop&w=720&q=75",
            imageAlt = "Specialty single-origin Ethiopian coffee beans drying in highland sun",
            imageSizeKb = 72,
            excerpt = "Perched over 2,000 meters above sea level amidst morning mist, Yirgacheffe produces coffee that resembles fine Earl Grey tea rather than conventional dark roasts.",
            sections = listOf(
                ArticleSection(
                    heading = "The Cradle of Arabica",
                    isQuestionAnswer = false,
                    paragraphs = listOf(
                        "Ethiopia is the biological birthplace of Coffea arabica. Unlike farms in Central America where specific cultivars like Caturra or Bourbon dominate, Yirgacheffe is populated by thousands of wild indigenous heirloom varietals.",
                        "These wild varietals grow organically in misty shade canopies, nourished by rich volcanic soils and cool montane nights that slow cherry maturation."
                    ),
                    anchorLinkText = "order freshly roasted Ethiopian beans",
                    anchorLinkUrl = "https://mistandmocha.com/menu"
                ),
                ArticleSection(
                    heading = "What gives Ethiopian Yirgacheffe its tea-like delicate body?",
                    isQuestionAnswer = true,
                    paragraphs = listOf(
                        "The defining character comes from washed wet processing. After harvest, cherries are pulped and fermented in cool mountain spring water for 36 to 48 hours to remove the mucilage cleanly.",
                        "This meticulous washing reveals pristine citric acidity reminiscent of Meyer lemon, white peach sweetness, and delicate floral scents of jasmine blossom."
                    ),
                    baristaTip = "Brew Yirgacheffe using slightly coarser grinds and 93°C water to accentuate its perfumed bouquet without creating bitterness."
                ),
                ArticleSection(
                    heading = "Why do elevation and mountain mist intensify bean sweetness?",
                    isQuestionAnswer = true,
                    paragraphs = listOf(
                        "Above 2,000 meters, lower oxygen pressure and cooler ambient temperatures slow down the respiration cycle of the coffee tree.",
                        "This extended ripening cycle allows the cherry to concentrate complex sucrose and organic malic acids inside the seed before harvest."
                    ),
                    anchorLinkText = "taste our single-origin flight in person",
                    anchorLinkUrl = "https://mistandmocha.com/reserve"
                )
            ),
            tags = listOf("Ethiopia", "Yirgacheffe", "Washed Process", "Floral Notes")
        ),

        Article(
            id = "art-3",
            slug = "mastering-espresso-crema-guide",
            canonicalUrl = "https://mistandmocha.com/blog/mastering-espresso-crema-guide",
            title = "Espresso Crema: Extraction Pressure, Fresh Roasting & Dialing In Shots",
            mainKeyword = "Espresso Crema",
            relatedKeywords = listOf("Extraction Pressure", "Fresh Roasting"),
            metaDescription = "Demystify espresso crema through optimized extraction pressure, fresh roasting windows, and precision dialing in for silky hazelnut crema in every cup.",
            category = "Barista Science",
            author = "Elena Vance",
            authorRole = "Head Roaster",
            datePublished = "October 5, 2026",
            readingTimeMinutes = 7,
            localDrawableRes = R.drawable.img_cafe_hero,
            imageUrl = "https://images.unsplash.com/photo-1510591509098-f4fdc6d0ff04?auto=format&fit=crop&w=720&q=75",
            imageAlt = "Rich hazelnut espresso crema pouring smoothly from bottomless portafilter",
            imageSizeKb = 82,
            excerpt = "That reddish-brown foam crowning your espresso is an emulsion of microscopic gas bubbles and coffee oils—here is how to master it.",
            sections = listOf(
                ArticleSection(
                    heading = "The Anatomy of Espresso Crema",
                    isQuestionAnswer = false,
                    paragraphs = listOf(
                        "Crema is a colloid: carbon dioxide gas trapped within a liquid matrix of coffee solids and aromatic emulsified lipids. When water is forced through a compressed coffee puck at 9 bars of pressure, gas dissolves into liquid.",
                        "Once the liquid emerges into atmospheric pressure, the dissolved gas expands into hundreds of thousands of microbubbles, forming a velvety blanket."
                    ),
                    anchorLinkText = "taste our signature house espresso",
                    anchorLinkUrl = "https://mistandmocha.com/menu"
                ),
                ArticleSection(
                    heading = "Is thick crema always a sign of superior espresso taste?",
                    isQuestionAnswer = true,
                    paragraphs = listOf(
                        "Contrary to popular belief, thick crema does not inherently equal delicious espresso. Highly dark-roasted beans or low-grade Robusta beans produce massive crema that often tastes bitter, ashy, and dry.",
                        "In specialty Arabica coffee, we look for 'tiger striping'—tawny amber flecks on a hazelnut background—which indicates balanced extraction of sugars and aromatic oils rather than excessive burnt carbon."
                    ),
                    baristaTip = "Always stir your espresso before sipping! The crema contains heavy bitters, and stirring integrates the sweet syrupy body with the bright top layer."
                ),
                ArticleSection(
                    heading = "How many days post-roast should beans rest before pulling espresso?",
                    isQuestionAnswer = true,
                    paragraphs = listOf(
                        "Espresso requires a rest period of 7 to 14 days following roasting. Freshly roasted beans straight from the drum are overloaded with carbon dioxide, causing violent degassing in the basket that leads to channeling and sourness.",
                        "After 10 days of gradual degassing, the bean cellar stabilizes, resulting in smooth, laminar extraction and long-lasting crema."
                    ),
                    anchorLinkText = "view our daily espresso dial-in sheet",
                    anchorLinkUrl = "https://mistandmocha.com/blog/science-of-coffee-roasting-first-crack"
                )
            ),
            tags = listOf("Espresso", "Dialing In", "Crema", "Machine Calibration")
        ),

        Article(
            id = "art-4",
            slug = "oat-milk-steaming-latte-art-secrets",
            canonicalUrl = "https://mistandmocha.com/blog/oat-milk-steaming-latte-art-secrets",
            title = "Oat Milk Steaming: Microfoam Texture, Temperature Limits & Latte Art",
            mainKeyword = "Oat Milk Steaming",
            relatedKeywords = listOf("Microfoam Texture", "Temperature Limits"),
            metaDescription = "Perfect your oat milk steaming craft with pro techniques for velvety microfoam texture, strict temperature limits, and sharp latte art rosettas.",
            category = "Barista Science",
            author = "Chloe Lin",
            authorRole = "Lead Barista & Latte Artist",
            datePublished = "October 3, 2026",
            readingTimeMinutes = 5,
            localDrawableRes = R.drawable.img_latte_art,
            imageUrl = "https://images.unsplash.com/photo-1534778101976-62847782c213?auto=format&fit=crop&w=720&q=75",
            imageAlt = "Barista pouring intricate swan latte art with velvety steamed oat milk",
            imageSizeKb = 84,
            excerpt = "Plant-based milks react differently to steam wand heat and protein shearing. Learn how to coax glossy, wet-paint microfoam from barista-edition oat milk.",
            sections = listOf(
                ArticleSection(
                    heading = "The Oat Milk Revolution in Specialty Coffee",
                    isQuestionAnswer = false,
                    paragraphs = listOf(
                        "Oat milk has firmly cemented itself as the preferred alternative milk worldwide because its natural malty sweetness complements the acidity of specialty single-origins without overpowering them.",
                        "However, oat milk lacks dairy casein proteins. Instead, it relies on soluble oat fiber (beta-glucans) and added plant dipotassium phosphate buffers to stabilize foam against heat."
                    ),
                    anchorLinkText = "try our artisan honey-lavender oat latte",
                    anchorLinkUrl = "https://mistandmocha.com/menu"
                ),
                ArticleSection(
                    heading = "Can you steam oat milk to the same temperature as dairy milk?",
                    isQuestionAnswer = true,
                    paragraphs = listOf(
                        "No. Dairy milk handles up to 65°C (150°F), but oat milk proteins denature and separate rapidly above 58°C (136°F).",
                        "If you overheat oat milk past 60°C, the natural starches gelatinize, resulting in a thick, gummy paste that cannot flow through an espresso canvas for latte art."
                    ),
                    baristaTip = "Introduce 80% of your aeration within the first 3 seconds while the milk is still ice cold, then submerge the steam wand tip to roll a fierce whirlpool."
                ),
                ArticleSection(
                    heading = "Why do some plant milks curdle when poured into light-roast espresso?",
                    isQuestionAnswer = true,
                    paragraphs = listOf(
                        "Curdling occurs due to an acute pH shock. Light-roast coffees naturally contain higher concentrations of citric and malic acids (pH 4.8 to 5.0).",
                        "Barista-grade oat milk contains food-grade dipotassium phosphate buffers that prevent the milk proteins from curdling upon contact with high-acid coffee."
                    ),
                    anchorLinkText = "sign up for our weekend milk texturing workshop",
                    anchorLinkUrl = "https://mistandmocha.com/reserve"
                )
            ),
            tags = listOf("Latte Art", "Oat Milk", "Steaming", "Plant-Based")
        ),

        Article(
            id = "art-5",
            slug = "cold-brew-steep-optimization",
            canonicalUrl = "https://mistandmocha.com/blog/cold-brew-steep-optimization",
            title = "Cold Brew Coffee: Coarse Grinds, Ambient Filtration & Concentrate Ratios",
            mainKeyword = "Cold Brew Coffee",
            relatedKeywords = listOf("Coarse Grinds", "Ambient Filtration"),
            metaDescription = "Elevate cold brew coffee using coarse grinds, ambient filtration, and slow-steeped concentrate ratios to achieve smooth sweetness with zero acidity.",
            category = "Brewing Craft",
            author = "Marcus Thorne",
            authorRole = "Green Coffee Buyer",
            datePublished = "September 29, 2026",
            readingTimeMinutes = 6,
            localDrawableRes = R.drawable.img_cafe_hero,
            imageUrl = "https://images.unsplash.com/photo-1461023058943-07fcbe16d735?auto=format&fit=crop&w=720&q=75",
            imageAlt = "Amber glass bottle of nitro cold brew surrounded by ice and whole coffee cherries",
            imageSizeKb = 76,
            excerpt = "Steeping coffee in cold water for 16 hours extracts sweet cacao and berry oils while leaving bitter caffeine-tannin bonds bound in the grounds.",
            sections = listOf(
                ArticleSection(
                    heading = "The Chemistry of Cold Extraction",
                    isQuestionAnswer = false,
                    paragraphs = listOf(
                        "Heat accelerates chemical reactions. When brewing hot, you extract acids in minutes; when brewing cold, you replace thermal energy with time.",
                        "Cold extraction leaves behind up to 60% of volatile chlorogenic acids, creating an exceptionally smooth beverage that sits easily on the stomach."
                    ),
                    anchorLinkText = "grab our bottled draft cold brew at the cafe",
                    anchorLinkUrl = "https://mistandmocha.com/menu"
                ),
                ArticleSection(
                    heading = "How long should you steep cold brew at room temperature vs fridge?",
                    isQuestionAnswer = true,
                    paragraphs = listOf(
                        "We strongly recommend room-temperature ambient steeping (20°C to 22°C) for 14 to 16 hours rather than 24 hours in the refrigerator.",
                        "Refrigerated steeping suppresses the solubility of aromatic esters, resulting in a brew that tastes muddy and woody rather than vibrant and chocolatey."
                    ),
                    baristaTip = "Always perform a two-stage filtration: first through stainless steel mesh, then through unbleached paper to eliminate dusty silt."
                ),
                ArticleSection(
                    heading = "What is the best brew ratio for cold brew concentrate?",
                    isQuestionAnswer = true,
                    paragraphs = listOf(
                        "We formulate our concentrate at a 1:7 coffee-to-water ratio using a coarse grind resembling kosher sea salt.",
                        "To serve, dilute 1:1 with crisp sparkling water over ice for a coffee spritz, or with creamy oat milk for a melted-fudge morning treat."
                    ),
                    anchorLinkText = "explore the cold drip Dutch coffee tower",
                    anchorLinkUrl = "https://mistandmocha.com/reserve"
                )
            ),
            tags = listOf("Cold Brew", "Slow Steep", "Summer Drinks", "Nitro Coffee")
        ),

        Article(
            id = "art-6",
            slug = "science-of-coffee-roasting-first-crack",
            canonicalUrl = "https://mistandmocha.com/blog/science-of-coffee-roasting-first-crack",
            title = "Coffee Roasting: First Crack Kinetics, Caramelization & Flavor Notes",
            mainKeyword = "Coffee Roasting",
            relatedKeywords = listOf("First Crack", "Caramelization"),
            metaDescription = "Explore artisan coffee roasting dynamics from the kinetic First Crack stage to bean caramelization that shapes vibrant fruity and chocolatey flavor profiles.",
            category = "Roasting Craft",
            author = "Elena Vance",
            authorRole = "Head Roaster",
            datePublished = "September 24, 2026",
            readingTimeMinutes = 8,
            localDrawableRes = R.drawable.img_cafe_hero,
            imageUrl = "https://images.unsplash.com/photo-1518832553480-cd0e625ed3e6?auto=format&fit=crop&w=720&q=75",
            imageAlt = "Gleaming cast-iron roaster cooling tray circulating aromatic freshly dropped beans",
            imageSizeKb = 85,
            excerpt = "Behind the glass of our cast-iron roaster drum, heat turns dense green seeds into brittle, aromatic gems across five distinct thermodynamic phases.",
            sections = listOf(
                ArticleSection(
                    heading = "The Transformation from Green to Brown",
                    isQuestionAnswer = false,
                    paragraphs = listOf(
                        "Green coffee seeds contain roughly 11% water, cellulose structures, and complex sugars. When charged into a 200°C drum, the seeds absorb heat during the Drying Phase.",
                        "At around 160°C, the Maillard reaction initiates: amino acids bond with reducing sugars to create hundreds of aromatic volatile compounds, turning the beans golden yellow."
                    ),
                    anchorLinkText = "tour the Mist & Mocha roasting drum",
                    anchorLinkUrl = "https://mistandmocha.com/about"
                ),
                ArticleSection(
                    heading = "What physical transformation occurs during first crack in the roaster?",
                    isQuestionAnswer = true,
                    paragraphs = listOf(
                        "First Crack is an exothermic acoustic event where internal steam pressure fractures the cellular wall of the bean, sounding like popcorn popping.",
                        "This rupture expands the bean volume by 60% and unlocks the Development Time Ratio (DTR). Every second post-first-crack determines whether the coffee retains lively floral acidity or shifts into deep baker's chocolate and toffee."
                    ),
                    baristaTip = "We roast our Mist & Mocha light roasts with a precise 14% DTR, cooling them within 90 seconds to freeze aromatic volatile esters."
                ),
                ArticleSection(
                    heading = "How does roasting speed influence organic acid preservation in coffee?",
                    isQuestionAnswer = true,
                    paragraphs = listOf(
                        "A fast roast curve with high convective heat transfer preserves bright malic and phosphoric acids, giving coffees their sparkling, juicy character.",
                        "A slower roast curve breaks down organic acids and caramelizes sucrose into brown maltol, resulting in a heavier, more viscous body."
                    ),
                    anchorLinkText = "purchase our limited microlot roasts",
                    anchorLinkUrl = "https://mistandmocha.com/menu"
                )
            ),
            tags = listOf("Roasting", "First Crack", "Thermodynamics", "Maillard")
        ),

        Article(
            id = "art-7",
            slug = "water-chemistry-for-specialty-coffee",
            canonicalUrl = "https://mistandmocha.com/blog/water-chemistry-for-specialty-coffee",
            title = "Coffee Water Chemistry: Mineral Hardness, TDS Levels & Flavor Extraction",
            mainKeyword = "Coffee Water Chemistry",
            relatedKeywords = listOf("Mineral Hardness", "TDS Levels"),
            metaDescription = "Optimize coffee water chemistry by balancing mineral hardness, magnesium ions, and target TDS levels to unlock the vibrant aromatics of delicate beans.",
            category = "Barista Science",
            author = "Marcus Thorne",
            authorRole = "Green Coffee Buyer",
            datePublished = "September 18, 2026",
            readingTimeMinutes = 6,
            localDrawableRes = R.drawable.img_latte_art,
            imageUrl = "https://images.unsplash.com/photo-1541167760496-1628856ab772?auto=format&fit=crop&w=720&q=75",
            imageAlt = "Crystal clear filtered water dropping onto freshly ground single-origin coffee",
            imageSizeKb = 71,
            excerpt = "Your brewed cup of coffee is 98.6% water. If your brewing water is out of balance, even the world's most expensive Gesha will taste flat or chalky.",
            sections = listOf(
                ArticleSection(
                    heading = "Water: The Invisible Solvent",
                    isQuestionAnswer = false,
                    paragraphs = listOf(
                        "Pure distilled water is surprisingly terrible at brewing coffee because it lacks positively charged mineral ions to bind and carry flavor compounds out of the grounds.",
                        "Conversely, municipal tap water is overloaded with bicarbonate buffers that neutralize delicate fruit acids like a sponge."
                    ),
                    anchorLinkText = "review our reverse osmosis remineralization recipe",
                    anchorLinkUrl = "https://mistandmocha.com/blog/art-of-slow-pour-over-brewing"
                ),
                ArticleSection(
                    heading = "Why does tap water produce dull and flat specialty coffee?",
                    isQuestionAnswer = true,
                    paragraphs = listOf(
                        "Tap water usually carries excess alkalinity (calcium carbonate). Alkalinity acts as a chemical buffer against coffee acids.",
                        "When you brew with high-bicarbonate water, the bright citrus and berry notes are instantly neutralized, leaving only dull bitterness and dry chalkiness on the palate."
                    ),
                    baristaTip = "Magnesium ions bind strongly to oxygen-rich aroma compounds (such as fruit esters), while calcium binds to creaminess and chocolate notes."
                ),
                ArticleSection(
                    heading = "What is the ideal TDS range recommended by the Specialty Coffee Association?",
                    isQuestionAnswer = true,
                    paragraphs = listOf(
                        "The SCA target is 120 to 150 parts per million (ppm) Total Dissolved Solids, with total hardness around 68 ppm and alkalinity around 40 ppm.",
                        "At Mist and Mocha, we run multi-stage Reverse Osmosis filtration and reinject custom blends of Epsom salts (magnesium sulfate) and sodium bicarbonate for crisp clarity."
                    ),
                    anchorLinkText = "sample our seasonal pour-over flight",
                    anchorLinkUrl = "https://mistandmocha.com/reserve"
                )
            ),
            tags = listOf("Water Quality", "TDS", "Minerals", "Extraction")
        ),

        Article(
            id = "art-8",
            slug = "aeropress-champion-techniques-inverted",
            canonicalUrl = "https://mistandmocha.com/blog/aeropress-champion-techniques-inverted",
            title = "AeroPress Brewing: Inverted Brewing, Plunge Timing & Clean Extraction",
            mainKeyword = "AeroPress Brewing",
            relatedKeywords = listOf("Inverted Brewing", "Plunge Timing"),
            metaDescription = "Unleash championship AeroPress brewing using inverted brewing orientation, deliberate plunge timing, and gentle agitation for a silky clean cup.",
            category = "Brewing Craft",
            author = "Chloe Lin",
            authorRole = "Lead Barista",
            datePublished = "September 12, 2026",
            readingTimeMinutes = 5,
            localDrawableRes = R.drawable.img_cafe_hero,
            imageUrl = "https://images.unsplash.com/photo-1517256064527-09c73fc73e38?auto=format&fit=crop&w=720&q=75",
            imageAlt = "Barista using the inverted AeroPress technique with precision scale and kettle",
            imageSizeKb = 79,
            excerpt = "Invented by a frisbee aerodynamicist, the AeroPress remains the most versatile, travel-proof, and forgiving manual coffee brewer in existence.",
            sections = listOf(
                ArticleSection(
                    heading = "Why the AeroPress Conquered the World",
                    isQuestionAnswer = false,
                    paragraphs = listOf(
                        "The AeroPress blends full immersion steeping (like a French press) with gentle air pressure filtration (like an espresso machine).",
                        "Because the coffee grounds steep uniformly in water before passing through a micro-filter, you achieve high extraction sweetness without grit or silt."
                    ),
                    anchorLinkText = "browse our travel brewing gear kit",
                    anchorLinkUrl = "https://mistandmocha.com/menu"
                ),
                ArticleSection(
                    heading = "Why do competitive baristas prefer the inverted AeroPress method?",
                    isQuestionAnswer = true,
                    paragraphs = listOf(
                        "In standard upright position, water begins dripping through the filter before you have stirred or allowed grounds to bloom properly.",
                        "By turning the brewer upside-down, you have complete mastery over immersion time, slurry agitation, and temperature stability before inverting onto your mug."
                    ),
                    baristaTip = "Always rinse two paper filters together in the cap—this creates a denser seal that yields unmatched cup transparency."
                ),
                ArticleSection(
                    heading = "Should you press all the way until the final hiss of air?",
                    isQuestionAnswer = true,
                    paragraphs = listOf(
                        "Stop pressing the moment you hear the first hiss of steam and air! The final pocket of compressed slurry contains harsh lipids and bitter fines.",
                        "Ending your plunge at the hiss preserves silky body and sweet aftertaste."
                    ),
                    anchorLinkText = "book a weekend morning seat at our brew bar",
                    anchorLinkUrl = "https://mistandmocha.com/reserve"
                )
            ),
            tags = listOf("AeroPress", "Inverted Method", "Manual Brew", "Travel Gear")
        ),

        Article(
            id = "art-9",
            slug = "swiss-water-decaf-coffee-renaissance",
            canonicalUrl = "https://mistandmocha.com/blog/swiss-water-decaf-coffee-renaissance",
            title = "Decaf Coffee: Swiss Water Process, Terroir Preservation & Evening Brews",
            mainKeyword = "Decaf Coffee",
            relatedKeywords = listOf("Swiss Water Process", "Terroir Preservation"),
            metaDescription = "Experience modern decaf coffee crafted through chemical-free Swiss Water Process, honoring genuine terroir preservation for deeply satisfying evening brews.",
            category = "Origin & Terroir",
            author = "Elena Vance",
            authorRole = "Head Roaster",
            datePublished = "September 6, 2026",
            readingTimeMinutes = 6,
            localDrawableRes = R.drawable.img_latte_art,
            imageUrl = "https://images.unsplash.com/photo-1509042239860-f550ce710b93?auto=format&fit=crop&w=720&q=75",
            imageAlt = "Artisan steaming cup of decaf specialty mocha beside evening candle and book",
            imageSizeKb = 83,
            excerpt = "Gone are the days when decaf meant stale beans stripped with chemical solvents. Welcome to the golden era of single-origin decaffeinated coffee.",
            sections = listOf(
                ArticleSection(
                    heading = "Rethinking the Decaf Stigma",
                    isQuestionAnswer = false,
                    paragraphs = listOf(
                        "For decades, decaf coffee was treated as an afterthought—made from low-grade rejected beans soaked in methylene chloride or ethyl acetate.",
                        "At Mist and Mocha, we believe that coffee lovers who drink coffee at 8:00 PM do so purely for flavor, so their cup deserves the utmost care."
                    ),
                    anchorLinkText = "order our Nightfall Colombian Decaf",
                    anchorLinkUrl = "https://mistandmocha.com/menu"
                ),
                ArticleSection(
                    heading = "Does Swiss Water processing strip away natural origin flavors?",
                    isQuestionAnswer = true,
                    paragraphs = listOf(
                        "No. The Swiss Water Process uses only pure water, temperature, and carbon osmosis filtration to remove 99.9% of caffeine molecules.",
                        "Because the green coffee extract is pre-saturated with all other soluble coffee compounds, only caffeine migrates across the gradient, leaving origin sugars and terroir intact."
                    ),
                    baristaTip = "Decaf beans are more brittle after caffeine removal; roast them gently and use a slightly finer grind for espresso."
                ),
                ArticleSection(
                    heading = "How does decaffeinated green coffee age compared to regular beans?",
                    isQuestionAnswer = true,
                    paragraphs = listOf(
                        "Because the cellular structure is softened during water extraction, decaf green beans absorb and release moisture more quickly.",
                        "We roast our decaf in small micro-batches every 3 days to guarantee peak freshness and caramel sweetness."
                    ),
                    anchorLinkText = "reserve your table for dessert & decaf",
                    anchorLinkUrl = "https://mistandmocha.com/reserve"
                )
            ),
            tags = listOf("Decaf", "Swiss Water", "Colombian Terroir", "Evening Coffee")
        ),

        Article(
            id = "art-10",
            slug = "artisan-coffee-food-pairings-pastries",
            canonicalUrl = "https://mistandmocha.com/blog/artisan-coffee-food-pairings-pastries",
            title = "Coffee Food Pairings: Sourdough Pastries, Flavor Contrasts & Artisan Roasts",
            mainKeyword = "Coffee Food Pairings",
            relatedKeywords = listOf("Sourdough Pastries", "Flavor Contrasts"),
            metaDescription = "Elevate your cafe experience with coffee food pairings, matching buttery sourdough pastries and bright flavor contrasts to our signature artisan roasts.",
            category = "Cafe & Culinary",
            author = "Chef Julian Ramos",
            authorRole = "Pastry Chef & Sommelier",
            datePublished = "August 30, 2026",
            readingTimeMinutes = 7,
            localDrawableRes = R.drawable.img_cafe_hero,
            imageUrl = "https://images.unsplash.com/photo-1509440159596-0249088772ff?auto=format&fit=crop&w=720&q=75",
            imageAlt = "Golden flaky sourdough croissant next to a velvety cappuccino with latte art",
            imageSizeKb = 86,
            excerpt = "When the high malic acidity of a Kenyan coffee meets the rich cultured butter of a warm flaky pastry, culinary alchemy takes place.",
            sections = listOf(
                ArticleSection(
                    heading = "The Art of Coffee Gastronomy",
                    isQuestionAnswer = false,
                    paragraphs = listOf(
                        "In traditional fine dining, wine pairing is celebrated; in modern artisan cafes, coffee pairing is just as nuanced and rewarding.",
                        "A well-matched bite cleanses your palate, softens astringency, and accentuates hidden chocolate or stone-fruit nuances in the bean."
                    ),
                    anchorLinkText = "view today's fresh bakery basket in the cafe",
                    anchorLinkUrl = "https://mistandmocha.com/menu"
                ),
                ArticleSection(
                    heading = "Why does a chocolate croissant pair best with washed Central American beans?",
                    isQuestionAnswer = true,
                    paragraphs = listOf(
                        "Washed Guatemalan and Costa Rican coffees possess sweet praline, red apple, and milk chocolate undertones with medium body.",
                        "The bitter cocoa batons inside the viennoiserie echo the roast notes, while the buttery lamination softens the coffee's crisp citric bite."
                    ),
                    baristaTip = "Take a sip of coffee first to coat your tongue, take a small bite of pastry, and take a second sip while the pastry dissolves."
                ),
                ArticleSection(
                    heading = "How does high coffee acidity cut through rich butter pastries?",
                    isQuestionAnswer = true,
                    paragraphs = listOf(
                        "Butter coats the taste buds in a thin lipid film that can mute delicate flavors over time. The vibrant phosphoric and malic acidity of African coffees acts as a refreshing palate cleanser.",
                        "Each sip cuts right through the fat, making every bite of pastry taste as light and crisp as the first."
                    ),
                    anchorLinkText = "reserve outdoor mist terrace seating",
                    anchorLinkUrl = "https://mistandmocha.com/reserve"
                )
            ),
            tags = listOf("Food Pairing", "Bakery", "Sourdough", "Pastries")
        ),

        Article(
            id = "art-11",
            slug = "french-press-coffee-slurry-skimming-technique",
            canonicalUrl = "https://mistandmocha.com/blog/french-press-coffee-slurry-skimming-technique",
            title = "French Press Coffee: Coarse Steeping, Slurry Skimming & Zero Silt Cups",
            mainKeyword = "French Press Coffee",
            relatedKeywords = listOf("Coarse Steeping", "Slurry Skimming"),
            metaDescription = "Rediscover French press coffee with our coarse steeping and crust skimming technique for a luscious, heavy-bodied cup with zero grimy silt.",
            category = "Brewing Craft",
            author = "Marcus Thorne",
            authorRole = "Green Coffee Buyer",
            datePublished = "August 22, 2026",
            readingTimeMinutes = 5,
            localDrawableRes = R.drawable.img_latte_art,
            imageUrl = "https://images.unsplash.com/photo-1544787219-7f47ccb76574?auto=format&fit=crop&w=720&q=75",
            imageAlt = "Copper and glass French press with dark roasted coffee steeping in golden light",
            imageSizeKb = 77,
            excerpt = "Most people press their French press immediately after 4 minutes and end up with muddy, bitter sludge. Here is the barista method that changes everything.",
            sections = listOf(
                ArticleSection(
                    heading = "The Unjust Reputation of the French Press",
                    isQuestionAnswer = false,
                    paragraphs = listOf(
                        "The French press (or cafetière) is capable of delivering the fullest mouthfeel of any manual brew method because its metal mesh filter does not absorb aromatic diterpene oils (cafestol and kahweol).",
                        "The secret to eliminating murky sediment is patience, gravity, and skimming."
                    ),
                    anchorLinkText = "view our grind size reference chart",
                    anchorLinkUrl = "https://mistandmocha.com/blog/art-of-slow-pour-over-brewing"
                ),
                ArticleSection(
                    heading = "Why should you skim the foamy crust before plunging French press?",
                    isQuestionAnswer = true,
                    paragraphs = listOf(
                        "At the 4-minute mark, break the floating crust with two spoons. You will notice a foamy layer of pale crema and floating micro-fines.",
                        "Using two warm spoons, skim off this top foam layer completely. That foam contains trapped astringent dust; removing it clarifies your cup dramatically."
                    ),
                    baristaTip = "Do not plunge all the way to the bottom! Lower the filter just beneath the liquid surface to act as a pour strainer."
                ),
                ArticleSection(
                    heading = "How long should French press really steep for maximum sweetness?",
                    isQuestionAnswer = true,
                    paragraphs = listOf(
                        "Contrary to old 4-minute instructions, modern coffee experts let the French press settle undisturbed for an additional 5 minutes after skimming (total 9 to 10 minutes).",
                        "Gravity pulls all remaining sediment to the floor of the carafe, leaving crystal-clear, intensely sweet nectar above."
                    ),
                    anchorLinkText = "order fresh dark roast beans",
                    anchorLinkUrl = "https://mistandmocha.com/menu"
                )
            ),
            tags = listOf("French Press", "Immersion", "Heavy Body", "Home Barista")
        )
    )

    val menuItems: List<MenuItem> = listOf(
        MenuItem(
            id = "menu-1",
            name = "Mist Signature Mocha",
            category = "Signature Drinks",
            price = "$6.75",
            description = "Double shot of single-origin espresso, Valrhona 70% dark chocolate ganache, infused with cardamom mist and steamed velvet milk.",
            tastingNotes = listOf("Rich Cocoa", "Spiced Cardamom", "Orange Peel", "Silk Texture"),
            isSignature = true
        ),
        MenuItem(
            id = "menu-2",
            name = "Highland Fog Latte",
            category = "Signature Drinks",
            price = "$6.50",
            description = "Micro-steamed oat milk with Earl Grey reduction, lavender honey syrup, and an espresso float crowned with edible cornflower.",
            tastingNotes = listOf("Bergamot", "Lavender Bloom", "Vanilla Bean", "Creamy Oat"),
            isSignature = true
        ),
        MenuItem(
            id = "menu-3",
            name = "Ethiopian Yirgacheffe V60",
            category = "Pour-Over Bar",
            price = "$6.00",
            description = "Handcrafted slow pour-over brewed at 94°C with mineral-balanced water. Exceptional floral tea-like clarity.",
            tastingNotes = listOf("Jasmine Blossom", "Meyer Lemon", "Bergamot", "Honey Finish"),
            isSignature = true
        ),
        MenuItem(
            id = "menu-4",
            name = "Colombian Geisha Microlot",
            category = "Pour-Over Bar",
            price = "$8.50",
            description = "Rare high-altitude anaerobic natural Gesha from Finca El Paraiso. Complex tropical aromatics.",
            tastingNotes = listOf("Passionfruit", "Lemongrass", "Papaya", "Jasmine Tea"),
            isSignature = false
        ),
        MenuItem(
            id = "menu-5",
            name = "Nitro Cold Brew on Tap",
            category = "Cold Bar",
            price = "$5.75",
            description = "16-hour steeped ambient cold brew charged with nitrogen for a cascading Guinness-style creamy head.",
            tastingNotes = listOf("Dark Chocolate", "Roasted Hazelnut", "Blackberry", "Zero Bitterness"),
            isSignature = true
        ),
        MenuItem(
            id = "menu-6",
            name = "Cardamom Brown Butter Croissant",
            category = "Bakery & Pastry",
            price = "$5.25",
            description = "Slow-fermented sourdough lamination baked daily with cultured French butter and fresh crushed green cardamom.",
            tastingNotes = listOf("Flaky Crisp", "Nutty Butter", "Warm Spice", "Caramelized Bottom"),
            isSignature = true
        ),
        MenuItem(
            id = "menu-7",
            name = "Wild Berry Sourdough Galette",
            category = "Bakery & Pastry",
            price = "$5.50",
            description = "Organic seasonal blackberries and blueberries folded into rye sourdough crust with thyme crumble.",
            tastingNotes = listOf("Tart Berry", "Earthly Rye", "Subtle Thyme", "Demerara Crunch"),
            isSignature = false
        )
    )

    fun getArticleBySlug(slug: String): Article? {
        return articles.find { it.slug.equals(slug, ignoreCase = true) }
    }

    fun getArticlesByCategory(category: String): List<Article> {
        if (category == "All") return articles
        return articles.filter { it.category.equals(category, ignoreCase = true) }
    }

    fun searchArticles(query: String): List<Article> {
        if (query.isBlank()) return articles
        val lower = query.lowercase().trim()
        return articles.filter {
            it.title.lowercase().contains(lower) ||
            it.mainKeyword.lowercase().contains(lower) ||
            it.relatedKeywords.any { k -> k.lowercase().contains(lower) } ||
            it.tags.any { t -> t.lowercase().contains(lower) } ||
            it.excerpt.lowercase().contains(lower)
        }
    }
}
