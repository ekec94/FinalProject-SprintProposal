package com.example.finalproject

// main class recipes with nested classes that are individual recipes that have name, prep time, img,
// resource, ingredients, and ingredient amounts

class Recipes {

    class DillDumpling {
        fun name(): String {
            return "Dill Vegetable and Dumpling Soup"
        }

        fun prepTime(): String {
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
                "tsp Dried Rosemary - Optional",
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
            val ingredientAmts: List<Double> =
                listOf(
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
            // val adjustedAmounts: ArrayList<Double>

            // for (item in ingredientAmts) {
            // val result: Double = item * 2 // test
            // adjustedAmounts.add(result)
            // }
            return ingredientAmts

        }

        fun instructions(): List<String> {
            return listOf(
                """
                    Add the dumplings in the end, so it's best to start making the dumpling batter. 
                    It has to sit for some time to let the flour set a bit. To make the dumplings, 
                    combine flour with a quarter amount of the salt, add water and whisk. Add oil 
                    and whisk again. The dumpling batter should be a creamy mixture, almost like 
                    a thicker sour cream. Let the dumpling batter sit until you make the soup.
                """.trimIndent(),
                """
                    Heat up a thick-bottomed pot. Add the cooking oil and chopped onions. 
                    Cook for a minute or two. Add carrots (cut into bite sized pieces), bay leaves, 
                    ground black pepper, minced garlic and dried dill. Stir and cook for a couple 
                    of minutes. Add the boiling water and let the soup boil under a lid, until the 
                    carrots are halfway cooked (about 10 minutes). Add potato cubes and salt. Boil, 
                    until the potatoes are almost soft. Now start adding the dumplings. Take a 
                    teaspoon of dumpling dough and carefully slide it into the boiling soup. 
                    Continue, until you are out of the dough. If all the dumplings are added, 
                    cover the pot with a lid and let the soup boil on a medium heat for 
                    7 - 10 minutes. In the end, add chopped parsley and finely chopped garlic clove. 
                    Taste for salt and serve.
                """.trimIndent()
                )
        }

        fun resource(): String{
            return "https://www.vegansandra.com/2015/01/easy-vegetable-and-dumpling-soup.html?spref=pi"
        }
    }
}
