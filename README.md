# Compressed-Chemistry

This mod is intended to use in the Compression modpack, but it will function outside of it.

https://www.curseforge.com/minecraft/modpacks/compression

Its purpose is to make tweaks to ChemLib (and down the line, Alchemistry) as they are needed by the pack.

Current features:

- Fixes the color clamping for tinted chemlib items, that could result in severe discoloration (like greenish gold plates)
- Allows overriding the texture of chemlib items that render the element abbreviation.
  - To do so, use a resourcepack and load item models under assets/chemlib/models/item/retextures.
  - Make sure the model has a blank texture on layer 0, since that's the one that gets tinted. A blank 16x16 png is included if needed.
  - Example: (/assets/chemlib/models/item/retextures/gold_plate.json)
`````{
    "parent": "minecraft:item/generated",
    "textures": {
    "layer0": "compressed_chemistry:item/blank_layer0",
    "layer1": "create:item/golden_sheet"
    }
    }`
