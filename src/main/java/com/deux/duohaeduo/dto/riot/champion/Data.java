package com.deux.duohaeduo.dto.riot.champion;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Data {

    @JsonAlias({
            "Garen", "Galio", "Gangplank", "Gragas", "Graves", "Gwen", "Gnar", "Nami", "Nasus", "Naafiri",
            "Nautilus", "Nocturne", "Nunu", "Nidalee", "Neeko", "Nilah", "Darius", "Diana", "Draven", "Ryze",
            "Rakan", "Rammus", "Lux", "Rumble", "Renata", "Renekton", "Leona", "RekSai", "Rell", "Rengar",
            "Lucian", "Lulu", "Leblanc", "LeeSin", "Riven", "Lissandra", "Lillia", "MasterYi", "Maokai", "Malzahar",
            "Malphite", "Mordekaiser", "Morgana", "DrMundo", "MissFortune", "Milio", "Bard", "Varus", "Vi", "Veigar",
            "Vayne", "Vex", "Belveth", "Velkoz", "Volibear", "Braum", "Briar", "Brand", "Vladimir", "Blitzcrank",
            "Viego", "Viktor", "Poppy", "Samira", "Sion", "Sylas", "Shaco", "Senna", "Seraphine", "Sejuani",
            "Sett", "Sona", "Soraka", "Shen", "Shyvana", "Smolder", "Swain", "Skarner", "Sivir", "XinZhao",
            "Syndra", "Singed", "Thresh", "Ahri", "Amumu", "AurelionSol", "Ivern", "Azir", "Akali", "Akshan",
            "Aatrox", "Aphelios", "Alistar", "Annie", "Anivia", "Ashe", "Yasuo", "Ekko", "Elise", "MonkeyKing",
            "Ornn", "Orianna", "Olaf", "Yone", "Yorick", "Udyr", "Urgot", "Warwick", "Yuumi", "Irelia",
            "Evelynn", "Ezreal", "Illaoi", "JarvanIV", "Xayah", "Zyra", "Zac", "Janna", "Jax", "Zed",
            "Xerath", "Zeri", "Jayce", "Zoe", "Ziggs", "Jhin", "Zilean", "Jinx", "Chogath", "Karma",
            "Camille", "Kassadin", "Karthus", "Cassiopeia", "Kaisa", "Khazix", "Katarina", "Kalista", "Kennen", "Caitlyn",
            "Kayn", "Kayle", "KogMaw", "Corki", "Quinn", "KSante", "Kled", "Qiyana", "Kindred", "Taric",
            "Talon", "Taliyah", "TahmKench", "Trundle", "Tristana", "Tryndamere", "TwistedFate", "Twitch", "Teemo", "Pyke",
            "Pantheon", "Fiddlesticks", "Fiora", "Fizz", "Heimerdinger", "Hecarim", "Hwei"})
    private ChampionInfo championInfo;

}
