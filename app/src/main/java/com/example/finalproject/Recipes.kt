package com.example.finalproject

// main class recipes with nested classes that are individual recipes that have name, cook time, img,
// resource, ingredients, and ingredient amounts - also added tags

// ingredient measurement unit will not adjust - so tablespoons will NOT turn into cups where necessary etc.
// and I don't feel like converting to grams

class Recipes {

    class DillDumpling {
        fun name(): String {
            return "Dill Vegetable and Dumpling Soup"
        }

        fun cookTime(): String {
            return "30 minutes"
        }

        fun img(): Int {
            return R.drawable.dilldumpling
        }

        fun ingredients(): List<String> {
            return listOf(
                "large heaping Tbsp All-Purpose Flour",
                "tsp Salt",
                "cup(s) of Water",
                "Tbsp Olive Oil",
                "tsp Dried Rosemary-optional",
                "Tbsp Cooking Oil",
                "Onion(s)",
                "Large Carrot(s)",
                "Bay Leaf",
                "tsp Ground Black Pepper",
                "Clove of Garlic",
                "tsp Dried Dill",
                "cup(s) of Boiling Water",
                "Potato(es)",
                "bunch of Fresh Parsley"
            )
        }

        // ingredients adjusted to one serving from four servings
        // measurement unit will not adjust - so tablespoons will NOT turn into cups where necessary etc.
        // and I don't feel like converting to grams
        fun ingredientAmounts(): List<Double> {
            return listOf(
                    1.25,
                    0.5,
                    0.125,
                    0.25,
                    0.125,
                    0.75,
                    0.5,
                    0.25,
                    0.5,
                    0.125,
                    0.75,
                    0.5,
                    1.5,
                    0.75,
                    0.25
                ) // amounts are in corresponding order of their matching ingredient
        }

        fun instructions(): List<String> {
            return listOf(
                """
                    For the Dumplings: 
                    
                    Add the dumplings in the end. Let the dumpling batter sit until you make the soup.
                """.trimIndent(),
                """
                    Combine flour with a quarter amount of the salt, add water and whisk. 
                    Add oil and whisk again.
                """.trimIndent(),
                """
                    The dumpling batter should be a creamy mixture, like a thicker sour cream.
                """.trimIndent(),
                """
                    For the Soup:
                    
                    Heat up a thick-bottomed pot. Add the cooking oil and chopped onions. Cook for a minute or two. 
                """.trimIndent(),
                """
                    Add carrots (cut into bite sized pieces), bay leaves, ground black pepper, minced garlic and dried dill. 
                    Stir and cook for a couple of minutes. 
                """.trimIndent(),
                """
                    Add the boiling water and let the soup boil under a lid, until the carrots are halfway cooked (about 10 minutes). 
                """.trimIndent(),
                """
                    Add potato cubes and salt. Boil, until the potatoes are almost soft. 
                """.trimIndent(),
                """
                    Now start adding the dumplings. Take a teaspoon of dumpling dough and carefully slide it into the boiling soup. 
                    Continue, until you are out of the dough. If all the dumplings are added, cover the pot with a lid and let the soup boil on a medium heat for 
                    7 - 10 minutes. 
                """.trimIndent(),
                """
                    At the end, add chopped parsley. Taste for salt and serve.
                """.trimIndent()
                )
        }

        fun resource(): String{
            return "https://www.vegansandra.com/2015/01/easy-vegetable-and-dumpling-soup.html?spref=pi"
        }

        fun filterTags(): List<Any>{
            // protein, carb type, prep time, calorie conscious
            return listOf("N/A", "N/A", 30, true)
        }
    }

    class FrenchOnion {
        fun name(): String{
            return "French Onion Soup"
        }

        fun cookTime(): String{
            return "80 Minutes"
        }

        fun img(): Int{
            return R.drawable.frenchonion
        }

        fun ingredients(): List<String> {
            return listOf(
                "stick Unsalted Butter",
                "large Yellow Onions-sliced",
                "Tbsp Dry Sherry",
                "Tbsp Sherry Vinegar-or to taste",
                "cup(s) Chicken Broth",
                "cup(s) Beef Broth",
                "sprigs Fresh Thyme",
                "slice(s) French Bread",
                "cup(s) shredded Gruyère Cheese-or your preferred cheese"
            )
        }

        // ingredients adjusted to one serving from six servings
        fun ingredientAmounts(): List<Double> {
                return listOf(
                    0.167,
                    1.0,
                    0.5,
                    0.167,
                    0.667,
                    0.667,
                    0.5,
                    1.0,
                    0.333
                ) // amounts are in corresponding order of their matching ingredient
        }

        fun instructions(): List<String> {
            return listOf(
                """
                    Preheat oven to 425 degrees F (220 degrees C)
                """.trimIndent(),
                """
                 Melt half the butter in a large, oven-safe skillet on medium heat. 
                 Stir in onions until they are all coated in butter. Transfer skillet to the 
                 preheated oven and cook onions, stirring occasionally, until they are tender and 
                 well browned, about 1 hour   
                """.trimIndent(),
                """
                    Transfer skillet to the stove top; cook and stir onions over medium heat until 
                    they start to brown and stick to the bottom of the pan, about 5 minutes. Pour 
                    sherry and vinegar into the pan, and bring to a boil while scraping browned 
                    bits of onion off the bottom of the pan with a wooden spoon.
                """.trimIndent(),
                """
                    Place caramelized onions in a large soup pot. Pour in chicken broth, beef broth, 
                    and thyme. Bring to a boil, skimming off any foam and fat that appear on top. 
                    Reduce heat to low and simmer for about an hour. Season with salt and pepper 
                    to taste.
                """.trimIndent(),
                """
                    Preheat the oven's broiler and set the oven rack about 6 inches from the heat source.
                """.trimIndent(),
                """
                    Generously brush French bread slices with melted butter. Place on a baking sheet 
                    and broil in the preheated oven until crisp and golden, about 5 minutes.
                """.trimIndent(),
                """
                    Ladle soup into heat-proof bowls, top each bowl with a piece of toasted bread, 
                    sprinkle with 2 to 3 tablespoons of cheese.
                """.trimIndent(),
                """
                    Broil bowls of soup under the broiler until cheese is golden and bubbly, 5 to 6 minutes.
                """.trimIndent()
            )
        }

        fun resource(): String{
            // this one was more edited from the original to match my brother's recipe
            return "https://www.allrecipes.com/recipe/223049/american-french-onion-soup/"
        }

        fun filterTags(): List<Any>{
            // protein, carb type, prep time, calorie conscious
            return listOf("N/A", "N/A", 80, false)
        }
    }

    class ChickenNoodle {
        fun name(): String{
            return "Chicken Noodle Soup"
        }

        fun cookTime(): String{
            return "20 Minutes"
        }

        fun img(): Int{
            return R.drawable.chickennoodle
        }

        fun ingredients(): List<String> {
            return listOf(
                "Tbsp Butter",
                "cup(s) diced Carrot",
                "cup(s) diced Onion",
                "cup(s) diced Celery",
                "tsp Fresh Thyme Leaves",
                "Tbsp melted Chicken Fat",
                "cup(s) Roasted Chicken Broth",
                "ounce(s) Uncooked Wide Egg Noodles",
                "Boneless Chicken Breast-cooked and cubed/shredded"
            )
        }

        // ingredients adjusted to one serving from eight servings
        fun ingredientAmounts(): List<Double> {
            return listOf(
                0.125,
                0.0625,
                0.0625,
                0.0625,
                0.03125,
                0.25,
                1.0,
                0.5,
                0.25
            ) // amounts are in corresponding order of their matching ingredient
        }

        fun instructions(): List<String> {
            return listOf(
                """
                    Melt butter in a large soup pot over medium heat. Stir in carrot, onion, celery, 
                    thyme, and salt. Add chicken fat; cook and stir until onions turn soft and 
                    translucent, 5 to 6 minutes.
                """.trimIndent(),
                """
                    Stir in roasted chicken broth and bring to a boil. Season with salt, if necessary.
                """.trimIndent(),
                """
                    Stir in egg noodles; cook until tender, about 5 minutes.
                """.trimIndent(),
                """
                    Add cooked chicken breast meat; simmer until heated through, about 5 minutes. 
                    Season with cayenne pepper(optional), salt, and black pepper.
                """.trimIndent()

            )
        }

        fun resource(): String{
            return "https://www.allrecipes.com/recipe/220416/chef-johns-homemade-chicken-noodle-soup/"
        }

        fun filterTags(): List<Any>{
            // protein, carb type, prep time, calorie conscious
            return listOf("Chicken", "Noodles", 20, true)
        }
    }

    class DublinCoddle {
        fun name(): String{
            return "Dublin Coddle\n" + "(Irish Sausage and Potato Stew)"
        }

        fun cookTime(): String{
            return "225 Minutes"
        }

        fun img(): Int{
            return R.drawable.dublincoddle
        }

        fun ingredients(): List<String> {
            return listOf(
                "strips Thick-Cut Bacon-cut into 1 inch pieces",
                "Tbsp Butter",
                "Yellow Onion(s)-chopped",
                "cloves Garlic-minced",
                "cup(s) Chopped Green Onions-extra for garnish",
                "cup(s) Stout Beer",
                "fresh Thyme Leaves",
                "cup Italian Parsley-chopped",
                "tsp Kosher Salt-or to taste",
                "pound(s) Yukon Gold Potatoes-peeled and halved",
                "cup(s) Chicken Broth",
                "large Pork Sausage Links"
            )
        }

        // ingredients adjusted to one serving from - servings
        fun ingredientAmounts(): List<Double> {
            return listOf(
                2.0,
                0.5,
                0.5,
                1.0,
                0.25,
                0.25,
                0.25,
                0.0625,
                0.5,
                0.75,
                1.0,
                1.5
            ) // amounts are in corresponding order of their matching ingredient
        }

        fun instructions(): List<String> {
            return listOf(
                """
                    Cook bacon in a Dutch oven or a large oven-safe pot with a lid over medium heat, 
                    turning occasionally, until evenly browned, about 10 minutes. Add butter, 
                    onions, and pinch of salt, and cook until onions are soft and translucent. Add 
                    garlic, and green onions, and cook stirring for 2 minutes.
                """.trimIndent(),
                """
                    Pour in beer, raise heat to high, and cook, stirring occasionally, until beer 
                    has reduced by about 75%. While beer is reducing, season with thyme, parsley, 
                    black pepper, salt, and pinch cayenne. Once beer has reduced, add potatoes and 
                    broth and bring to a simmer.
                """.trimIndent(),
                """
                    Preheat the oven to 300 degrees F (150 degrees C)
                """.trimIndent(),
                """
                    Prick sausage on both sides, and add to the pot on top of the other ingredients.
                """.trimIndent(),
                """
                    Cover and place pot into the preheated oven. Cook for about 2 1/2 hours. Remove 
                    the lid, and continue cooking uncovered for about 1 more hour.
                """.trimIndent(),
                """
                    Remove from oven and skim excess fat from top before serving. Garnish top with 
                    green onions, if desired.
                """.trimIndent()
            )
        }

        fun resource(): String{
            return "https://www.allrecipes.com/dublin-coddle-irish-sausage-and-potato-stew-recipe-7185428"
        }

        fun filterTags(): List<Any>{
            // protein, carb type, prep time, calorie conscious
            return listOf("Pork", "N/A", 225, false)
        }
    }
}
