# JoinTitle [![Build Status](https://travis-ci.com/Freshmilkymilk/JoinTitle.svg?branch=master)](https://travis-ci.com/Freshmilkymilk/JoinTitle)

Simple plugin which send custom title on player loggin.

# Dependency

[Luckperms](https://ore.spongepowered.org/Luck/LuckPerms) Optional = true.

[PlaceholderAPI](https://forums.spongepowered.org/t/placeholderapi-a-hub-for-your-placeholders/16200) Optional = false.

# Commands:

Alias for jointitle: "jt" or "jointitle".

reload - permission: jointitle.commands.admin, discription: Reloads plugin config.

send <admin/vip/default> - permission: jointitle.commands.admin, discription: Send you specified title (Useful to check/edit text).

# Extra info

There is 3 sample to make custom title, admin/vip/default and 3 permission to apply on user.

Admin title - permission: jointitle.title.admin (or wildcard)

VIP title - permission: jointitle.title.vip

Default title - permission: jointitle.title.default

# Config

Default {
    # Sets the duration in ticks of the fade in effect of the title. Default 101ticks = 5sec.
    FadeIn=101
    # Sets the duration in ticks of the fade out effect of the title. Default 101ticks = 5sec.
    FadeOut=101
    # Sets the duration in ticks how long the title should stay on. Default 202ticks = 10sec.
    Staytime=202
    # Your text need to be between :and#. For ex title:Welcome to my server#
    Text="#title:title#subtitle:subtitle#actionbar:actionbar"
}

Your text need to be between #title:/#subtitle:/#actionbar: and # supports color codes and placeholders. 

>Same sample for Admin and VIP 

# Showcase

https://imgur.com/bKcMM6l

# ChangeLog

- 24.09.20 Updated to Sponge API 7.3.0 and LuckPerms API 5.1.
- 16.07.19 Nothing special just coding things, instead of having 1 heavy main.class i split it into smaller classes.
