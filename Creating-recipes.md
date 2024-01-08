As of Chipped 1.1.1 for all versions supported, the recipe system has been overhauled and it is now extremely simple to create a new recipe for Chipped.

To add a new recipe, create an **item** tag that contains the blocks you want to be interchangeable with one another.

* Fabric Tutorial for Tags: https://fabricmc.net/wiki/tutorial:tags

* Forge Tutorial for Tags: https://mcforge.readthedocs.io/en/latest/utilities/tags/

Once you have created and registered your tags, you can use them in your recipe!

Chipped currently has 7 tables you can add recipes to:
* Alchemy Bench: `chipped:alchemy_bench`
* Botanist Workbench: `chipped:botanist_workbench`
* Carpenters table: `chipped:carpenters_table`
* Glassblower: `chipped:glassblower`
* Loom: `chipped:loom_table`
* Mason's table: `chipped:mason_table`
* Tinkering table: `chipped:tinkering_table`

Create a json file in `resources/data/modid/recipes/[name.json]`

Note* You can use any name for your json file, but for organization's sake, we recommend you use the same name as the table you are adding recipes to, like `alchemy_bench.json`

In your json, simply add the tag you created to the table you want from the list above, like so:

```
{
  "type": "chipped:alchemy_bench",
  "tags": [
    "chipped:obsidian",
    "chipped:crying_obsidian",
    "chipped:glowstone",
    "chipped:sea_lantern"
  ]
}
```

You do not need to create a json for every recipe you wish to add to a table. At most, you should have 7 json files to add recipes to all tables in the mod, one for each table. Every tag added to the list will create a recipe independent of the other tags in the list, so adding `chipped:obsidian` and `chipped:glowstone` to the `alchemy_bench.json` recipe json will not make blocks in `chipped:obsidian` output blocks from the `chipped:glowstone` tag.

This will make any blocks in each of the tags interchangeable with one another in the table that you specified. In the example above, for instance, all blocks in the `chipped:obsidian` tag will, when put into the Alchemy Bench, display all other blocks in the `chipped:obsidian` tag. 