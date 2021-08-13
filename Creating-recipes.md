## Data packs

As of Chipped 1.1.1 for all versions supported, the recipe system has been overhauled and it is now extremely simple to create a new recipe for Chipped.

To add a new recipe, create a tag that contains the blocks you want to be interchangeable with one another.

* Fabric Tutorial for Tags: https://fabricmc.net/wiki/tutorial:tags

* Forge Tutorial for Tags: https://mcforge.readthedocs.io/en/latest/utilities/tags/

Once you have created and registered your tags, you can use them in your recipe!

Chipped currently has 7 tables you can add recipes to:
* Alchemy Bench: `chipped:alchemy_bench`
* Botanist Workbench: `chipped:botanist_workbench`
* Carpenters Workbench: `chipped:carpenters_workbench`
* Glassblower: `chipped:glassblower`
* Loom: `chipped:loom_table`
* Mason's table: `chipped:mason_table`
* Mechanist's Workbench: `chipped:mechanist_workbench`

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