# AAGear
[<img src="https://i.imgur.com/gJilCLf.png" width="250"/>](https://i.imgur.com/gJilCLf.png) [<img src="https://i.imgur.com/pwIEfeK.png" width="250"/>](https://i.imgur.com/pwIEfeK.png)

*Two examples of custom gear items, created by AAGear*

![CC BY-NC-ND 4.0](https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png "CC BY-NC-ND 4.0 (no commerical usage, no derivative works)")

AAGear is an easily extensible custom gear system for Spigot 1.19 and Java 17. It provides a huge variety of custom gear items by default, and more can be added by extending the `GearItem` class.
## Code overview (for reviewers or possible collaborators!)
Here is a break-down of what the different packages of AAGear handle:
- aagear: contains `GearHandler`, which handles plugin initialisation & commands issued by users. The only reason to modify this class is if you have created a `GearItem` that you wish to be obtainable through the `/gear give` command, in which case you'll need to add your item to the `gearMap`.
- aagear.utility: contains important utility classes, which handle tasks such as string manipulation, item creation, and granting items XP. All of the information about a gear item is saved by AAGear in that item's 'lore', which is a `List<String>` attached to each item and saved by the game (it is also the only way we can reliably save custom data about an item). As a result, string manipulation needs to be performed almost constantly.
- aagear.rarity: contains an enum defining item rarities, and some simple mapping functions, such as `RarityMapper.getRarityLine` which takes an item rarity and returns its string representation.
- aagear.listeners: contains a variety of event listeners, handling conversion of default Minecraft items into custom gear items, and taking actions such as granting XP and executing effects on events such as block breaking.
- aagear.items: contains `GearItem`, the abstract class which all gear items extend, and all the custom gear items that AAGear supports.

## Getting started

AAGear has one hard dependency - Vault. Vault can be found on SpigotMC, and is a requirement for many other common plugins - if you're running a server, it's recommended you have it installed! 

AAGear can be run on any Spigot 1.19 server by dropping the compiled .jar into its 'plugin' directory. Spigot-derivatives such as Paper will also work. 

Please note the license for AAGear does not allow it to be used for commercial purposes. This means if you run your Minecraft server for-profit (e.g. you sell in-game items or ranks), you are not permitted to use AAGear.
