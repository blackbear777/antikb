# AntiKnockback

A server-side Forge mod for **Minecraft 1.8.9** that reduces or fully removes
knockback from melee hits, applied uniformly to every player on the server
(this is a server rule, not a per-player advantage — it only needs to be on
the server, not on clients).

## What it does

- Listens for `LivingKnockBackEvent` and scales the knockback strength by a
  configurable multiplier.
- `strengthMultiplier = 0.0` (default) → knockback fully disabled.
- `strengthMultiplier = 1.0` → vanilla knockback.
- Anything in between/above scales it down/up.
- Config file is written to `config/antikb.cfg` after the first server start.

## Push this to GitHub

From inside this folder:

```bash
git init
git add .
git commit -m "Initial commit: AntiKnockback mod"
git branch -M main
git remote add origin https://github.com/<your-username>/<your-repo>.git
git push -u origin main
```

## Get a built .jar

This repo includes `.github/workflows/build.yml`, which auto-builds the jar
on every push using GitHub Actions (Forge's old build tooling needs
Java 8 + Gradle 2.14, which the workflow installs for you — no local setup
needed).

After pushing:
1. Go to your repo on GitHub → **Actions** tab.
2. Open the latest "Build Mod Jar" run.
3. Download the `antikb-jar` artifact once it finishes (a couple minutes).
4. Unzip it — inside is `antikb-1.0.0.jar`.

## Install on your server

1. Make sure your server is running **Forge 1.8.9** (not vanilla — this
   requires the Forge server jar).
2. Drop `antikb-1.0.0.jar` into your server's `mods/` folder.
3. Start the server once, then stop it.
4. Edit `config/antikb.cfg`, set `strengthMultiplier` to whatever you want
   (0.0 = no knockback, 1.0 = vanilla), then restart.

## Build locally instead (optional)

If you'd rather build on your own machine instead of using Actions, you need
Java 8 and Gradle 2.14 installed, then from the project folder:

```bash
gradle build
```

The jar will be in `build/libs/`.
