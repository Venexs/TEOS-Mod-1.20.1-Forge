# The Element of Chaos — Minecraft Mod

A Minecraft Forge mod based on my story, *The Element of Chaos*.

The project brings parts of the story's magic system, items, and locations into Minecraft. It is built for Minecraft 1.20.1 using Java, Forge, and MCreator.

**This project is a work in progress.** Features and mechanics are still being developed, and the mod is not yet a complete representation of the story.

## Current Features

### Magic System
- Choose a magical element: Fire, Water, or Air.
- Use key-bound abilities to cast magic.
- Player magic selection is stored using Forge player capabilities.
- Custom projectile and particle effects.

### Abilities
The current ability implementations include:

- **Fire Rock** — launches a fire-based projectile.
- **Wind Blade** — launches a wind-based projectile.
- **Fire Wall** — creates a temporary structure of fire and stone blocks.
- **Fire Laser** — projects a beam that damages entities along its path.

### Items and Equipment
- Obsidian Sword
- Red Gem and Broken Red Gem
- Mana Soul
- Adventurer's Leather Armour
- Sharpened Obsidian

### Blocks and Materials
- Mana Infused Stone
- Elvina Wood, Stripped Elvina Wood, and Elvina Leaves
- Ice Bricks and Polished Ice
- Custom slabs and stairs

### Elven World
The mod includes a custom dimension called the **Elven World**, with:
- A custom portal and portal igniter.
- The Elven Wasteland biome.
- Custom sky and fog effects.
- Elvina-based blocks and materials.

## Controls

The default ability keys are:

| Key | Action |
|---|---|
| `X` | Ability One |
| `Z` | Ability Two |
| `C` | Ability Three |

These key bindings can be changed through Minecraft's Controls menu.

The mod also includes an element-selection interface for choosing a magical element.

## Requirements

- Minecraft **1.20.1**
- Minecraft Forge **47.4.22**
- Java **17**

## Building from Source

Clone the repository:

```bash
git clone https://github.com/Venexs/TEOS-Mod-1.20.1-Forge.git
cd TEOS-Mod-1.20.1-Forge
```

Run the client development environment:

**Windows**
```bat
gradlew.bat runClient
```

**Linux**
```bash
./gradlew runClient
```

To build the mod:

**Windows**
```bat
gradlew.bat build
```

**Linux**
```bash
./gradlew build
```

The generated JAR should be located in:

```text
build/libs/
```

## Development

The project uses:
- Java 17
- Minecraft Forge 1.20.1
- MCreator-generated source and resources
- Gradle for building and development

The repository contains the MCreator project data, Java source files, textures, models, sounds, recipes, and world-generation resources.

## Project Status

The mod is actively being developed alongside the story.

Some systems are implemented, while others are incomplete or subject to change. Compatibility, balance, and gameplay behaviour may change as development continues.

## License

This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.
