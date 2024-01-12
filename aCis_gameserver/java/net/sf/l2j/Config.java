package net.sf.l2j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import net.sf.l2j.commons.config.ExProperties;
import net.sf.l2j.commons.logging.CLogger;
import net.sf.l2j.commons.math.MathUtil;

import net.sf.l2j.gameserver.enums.GeoType;
import net.sf.l2j.gameserver.model.holder.IntIntHolder;
import net.sf.l2j.gameserver.model.olympiad.enums.OlympiadPeriod;

/**
 * This class contains global server configuration.<br>
 * It has static final fields initialized from configuration files.
 */
public final class Config
{
	private static final CLogger LOGGER = new CLogger(Config.class.getName());
	
	public static final String CHAT_FILTER_FILE = "./config/chatfilter.txt";
	
	public static final String CLANS_FILE = "./config/clans.properties";
	public static final String EVENTS_FILE = "./config/events.properties";
	public static final String GEOENGINE_FILE = "./config/geoengine.properties";
	public static final String HEXID_FILE = "./config/hexid.txt";
	public static final String LOGINSERVER_FILE = "./config/loginserver.properties";
	public static final String NPCS_FILE = "./config/npcs.properties";
	public static final String OFFLINE_FILE = "./config/offlineshop.properties";
	public static final String PLAYERS_FILE = "./config/players.properties";
	public static final String RATES_FILE = "./config/rates.properties";
	public static final String RUS_ACIS_FILE = "./config/rus_acis.properties";
	public static final String SERVER_FILE = "./config/server.properties";
	public static final String SIEGE_FILE = "./config/siege.properties";
	
	// --------------------------------------------------
	// Clans settings
	// --------------------------------------------------
	
	/** Clans */
	public static int CLAN_JOIN_DAYS;
	public static int CLAN_CREATE_DAYS;
	public static int CLAN_DISSOLVE_DAYS;
	public static int ALLY_JOIN_DAYS_WHEN_LEAVED;
	public static int ALLY_JOIN_DAYS_WHEN_DISMISSED;
	public static int ACCEPT_CLAN_DAYS_WHEN_DISMISSED;
	public static int CREATE_ALLY_DAYS_WHEN_DISSOLVED;
	public static int MAX_NUM_OF_CLANS_IN_ALLY;
	public static int CLAN_MEMBERS_FOR_WAR;
	public static int CLAN_WAR_PENALTY_WHEN_ENDED;
	public static boolean MEMBERS_CAN_WITHDRAW_FROM_CLANWH;
	
	/** Manor */
	public static int MANOR_REFRESH_TIME;
	public static int MANOR_REFRESH_MIN;
	public static int MANOR_APPROVE_TIME;
	public static int MANOR_APPROVE_MIN;
	public static int MANOR_MAINTENANCE_MIN;
	public static int MANOR_SAVE_PERIOD_RATE;
	
	/** Clan Hall function */
	public static long CH_TELE_FEE_RATIO;
	public static int CH_TELE1_FEE;
	public static int CH_TELE2_FEE;
	public static long CH_SUPPORT_FEE_RATIO;
	public static int CH_SUPPORT1_FEE;
	public static int CH_SUPPORT2_FEE;
	public static int CH_SUPPORT3_FEE;
	public static int CH_SUPPORT4_FEE;
	public static int CH_SUPPORT5_FEE;
	public static int CH_SUPPORT6_FEE;
	public static int CH_SUPPORT7_FEE;
	public static int CH_SUPPORT8_FEE;
	public static long CH_MPREG_FEE_RATIO;
	public static int CH_MPREG1_FEE;
	public static int CH_MPREG2_FEE;
	public static int CH_MPREG3_FEE;
	public static int CH_MPREG4_FEE;
	public static int CH_MPREG5_FEE;
	public static long CH_HPREG_FEE_RATIO;
	public static int CH_HPREG1_FEE;
	public static int CH_HPREG2_FEE;
	public static int CH_HPREG3_FEE;
	public static int CH_HPREG4_FEE;
	public static int CH_HPREG5_FEE;
	public static int CH_HPREG6_FEE;
	public static int CH_HPREG7_FEE;
	public static int CH_HPREG8_FEE;
	public static int CH_HPREG9_FEE;
	public static int CH_HPREG10_FEE;
	public static int CH_HPREG11_FEE;
	public static int CH_HPREG12_FEE;
	public static int CH_HPREG13_FEE;
	public static long CH_EXPREG_FEE_RATIO;
	public static int CH_EXPREG1_FEE;
	public static int CH_EXPREG2_FEE;
	public static int CH_EXPREG3_FEE;
	public static int CH_EXPREG4_FEE;
	public static int CH_EXPREG5_FEE;
	public static int CH_EXPREG6_FEE;
	public static int CH_EXPREG7_FEE;
	public static long CH_ITEM_FEE_RATIO;
	public static int CH_ITEM1_FEE;
	public static int CH_ITEM2_FEE;
	public static int CH_ITEM3_FEE;
	public static long CH_CURTAIN_FEE_RATIO;
	public static int CH_CURTAIN1_FEE;
	public static int CH_CURTAIN2_FEE;
	public static long CH_FRONT_FEE_RATIO;
	public static int CH_FRONT1_FEE;
	public static int CH_FRONT2_FEE;
	
	// --------------------------------------------------
	// Castle Settings
	// --------------------------------------------------
	public static long CS_TELE_FEE_RATIO;
	public static int CS_TELE1_FEE;
	public static int CS_TELE2_FEE;
	public static long CS_MPREG_FEE_RATIO;
	public static int CS_MPREG1_FEE;
	public static int CS_MPREG2_FEE;
	public static int CS_MPREG3_FEE;
	public static int CS_MPREG4_FEE;
	public static long CS_HPREG_FEE_RATIO;
	public static int CS_HPREG1_FEE;
	public static int CS_HPREG2_FEE;
	public static int CS_HPREG3_FEE;
	public static int CS_HPREG4_FEE;
	public static int CS_HPREG5_FEE;
	public static long CS_EXPREG_FEE_RATIO;
	public static int CS_EXPREG1_FEE;
	public static int CS_EXPREG2_FEE;
	public static int CS_EXPREG3_FEE;
	public static int CS_EXPREG4_FEE;
	public static long CS_SUPPORT_FEE_RATIO;
	public static int CS_SUPPORT1_FEE;
	public static int CS_SUPPORT2_FEE;
	public static int CS_SUPPORT3_FEE;
	public static int CS_SUPPORT4_FEE;
	
	// --------------------------------------------------
	// Events settings
	// --------------------------------------------------
	
	/** Olympiad */
	public static int OLY_START_TIME;
	public static int OLY_MIN;
	public static long OLY_CPERIOD;
	public static long OLY_BATTLE;
	public static long OLY_WPERIOD;
	public static long OLY_VPERIOD;
	public static int OLY_WAIT_TIME;
	public static int OLY_WAIT_BATTLE;
	public static int OLY_WAIT_END;
	public static int OLY_START_POINTS;
	public static int OLY_WEEKLY_POINTS;
	public static int OLY_MIN_MATCHES;
	public static int OLY_CLASSED;
	public static int OLY_NONCLASSED;
	public static IntIntHolder[] OLY_CLASSED_REWARD;
	public static IntIntHolder[] OLY_NONCLASSED_REWARD;
	public static int OLY_GP_PER_POINT;
	public static int OLY_HERO_POINTS;
	public static int OLY_RANK1_POINTS;
	public static int OLY_RANK2_POINTS;
	public static int OLY_RANK3_POINTS;
	public static int OLY_RANK4_POINTS;
	public static int OLY_RANK5_POINTS;
	public static int OLY_MAX_POINTS;
	public static int OLY_DIVIDER_CLASSED;
	public static int OLY_DIVIDER_NON_CLASSED;
	public static boolean OLY_ANNOUNCE_GAMES;
	public static int OLY_ENCHANT_LIMIT;
	
	/** SevenSigns Festival */
	public static boolean SEVEN_SIGNS_BYPASS_PREREQUISITES;
	public static int FESTIVAL_MIN_PLAYER;
	public static int MAXIMUM_PLAYER_CONTRIB;
	public static long FESTIVAL_MANAGER_START;
	public static long FESTIVAL_LENGTH;
	public static long FESTIVAL_CYCLE_LENGTH;
	public static long FESTIVAL_FIRST_SPAWN;
	public static long FESTIVAL_FIRST_SWARM;
	public static long FESTIVAL_SECOND_SPAWN;
	public static long FESTIVAL_SECOND_SWARM;
	public static long FESTIVAL_CHEST_SPAWN;
	
	/** Four Sepulchers */
	public static int FS_TIME_ENTRY;
	public static int FS_TIME_END;
	public static int FS_PARTY_MEMBER_COUNT;
	
	/** dimensional rift */
	public static int RIFT_MIN_PARTY_SIZE;
	public static int RIFT_SPAWN_DELAY;
	public static int RIFT_MAX_JUMPS;
	public static int RIFT_AUTO_JUMPS_TIME_MIN;
	public static int RIFT_AUTO_JUMPS_TIME_MAX;
	public static int RIFT_ENTER_COST_RECRUIT;
	public static int RIFT_ENTER_COST_SOLDIER;
	public static int RIFT_ENTER_COST_OFFICER;
	public static int RIFT_ENTER_COST_CAPTAIN;
	public static int RIFT_ENTER_COST_COMMANDER;
	public static int RIFT_ENTER_COST_HERO;
	public static double RIFT_BOSS_ROOM_TIME_MULTIPLY;
	
	/** Lottery */
	public static int LOTTERY_PRIZE;
	public static int LOTTERY_TICKET_PRICE;
	public static double LOTTERY_5_NUMBER_RATE;
	public static double LOTTERY_4_NUMBER_RATE;
	public static double LOTTERY_3_NUMBER_RATE;
	public static int LOTTERY_2_AND_1_NUMBER_PRIZE;
	
	/** Fishing tournament */
	public static boolean ALLOW_FISH_CHAMPIONSHIP;
	public static int FISH_CHAMPIONSHIP_REWARD_ITEM;
	public static int FISH_CHAMPIONSHIP_REWARD_1;
	public static int FISH_CHAMPIONSHIP_REWARD_2;
	public static int FISH_CHAMPIONSHIP_REWARD_3;
	public static int FISH_CHAMPIONSHIP_REWARD_4;
	public static int FISH_CHAMPIONSHIP_REWARD_5;
	
	public static int EVENT_MEDAL_COUNT;
	public static int EVENT_MEDAL_CHANCE;
	
	public static int GLITTERING_MEDAL_COUNT;
	public static int GLITTERING_MEDAL_CHANCE;
	
	public static int STAR_CHANCE;
	public static int BEAD_CHANCE;
	public static int FIR_CHANCE;
	public static int FLOWER_CHANCE;
	
	public static int STAR_COUNT;
	public static int BEAD_COUNT;
	public static int FIR_COUNT;
	public static int FLOWER_COUNT;
	
	public static boolean EVENT_COMMANDS;
	
	public static boolean CTF_EVENT_ENABLED;
	public static String[] CTF_EVENT_INTERVAL;
	public static int CTF_EVENT_PARTICIPATION_TIME;
	public static int CTF_EVENT_RUNNING_TIME;
	public static String CTF_NPC_LOC_NAME;
	public static int CTF_EVENT_PARTICIPATION_NPC_ID;
	public static int CTF_EVENT_TEAM_1_HEADQUARTERS_ID;
	public static int CTF_EVENT_TEAM_2_HEADQUARTERS_ID;
	public static int CTF_EVENT_TEAM_1_FLAG;
	public static int CTF_EVENT_TEAM_2_FLAG;
	public static int CTF_EVENT_CAPTURE_SKILL;
	public static int[] CTF_EVENT_PARTICIPATION_NPC_COORDINATES = new int[4];
	public static int[] CTF_EVENT_PARTICIPATION_FEE = new int[2];
	public static int CTF_EVENT_MIN_PLAYERS_IN_TEAMS;
	public static int CTF_EVENT_MAX_PLAYERS_IN_TEAMS;
	public static int CTF_EVENT_RESPAWN_TELEPORT_DELAY;
	public static int CTF_EVENT_START_LEAVE_TELEPORT_DELAY;
	public static String CTF_EVENT_TEAM_1_NAME;
	public static int[] CTF_EVENT_TEAM_1_COORDINATES = new int[3];
	public static String CTF_EVENT_TEAM_2_NAME;
	public static int[] CTF_EVENT_TEAM_2_COORDINATES = new int[3];
	public static int[] CTF_EVENT_TEAM_1_FLAG_COORDINATES = new int[4];
	public static int[] CTF_EVENT_TEAM_2_FLAG_COORDINATES = new int[4];
	public static List<int[]> CTF_EVENT_REWARDS;
	public static boolean CTF_EVENT_TARGET_TEAM_MEMBERS_ALLOWED;
	public static boolean CTF_EVENT_SCROLL_ALLOWED;
	public static boolean CTF_EVENT_POTIONS_ALLOWED;
	public static boolean CTF_EVENT_SUMMON_BY_ITEM_ALLOWED;
	public static List<Integer> CTF_DOORS_IDS_TO_OPEN;
	public static List<Integer> CTF_DOORS_IDS_TO_CLOSE;
	public static boolean CTF_REWARD_TEAM_TIE;
	public static byte CTF_EVENT_MIN_LVL;
	public static byte CTF_EVENT_MAX_LVL;
	public static int CTF_EVENT_EFFECTS_REMOVAL;
	public static Map<Integer, Integer> CTF_EVENT_FIGHTER_BUFFS;
	public static Map<Integer, Integer> CTF_EVENT_MAGE_BUFFS;
	
	public static boolean DM_EVENT_ENABLED;
	public static String[] DM_EVENT_INTERVAL;
	public static Long DM_EVENT_PARTICIPATION_TIME;
	public static int DM_EVENT_RUNNING_TIME;
	public static String DM_NPC_LOC_NAME;
	public static int DM_EVENT_PARTICIPATION_NPC_ID;
	public static int[] DM_EVENT_PARTICIPATION_NPC_COORDINATES = new int[4];
	public static int[] DM_EVENT_PARTICIPATION_FEE = new int[2];
	public static int DM_EVENT_MIN_PLAYERS;
	public static int DM_EVENT_MAX_PLAYERS;
	public static int DM_EVENT_RESPAWN_TELEPORT_DELAY;
	public static int DM_EVENT_START_LEAVE_TELEPORT_DELAY;
	public static List<int[]> DM_EVENT_PLAYER_COORDINATES;
	public static Map<Integer, List<int[]>> DM_EVENT_REWARDS;
	public static int DM_REWARD_FIRST_PLAYERS;
	public static boolean DM_SHOW_TOP_RANK;
	public static int DM_TOP_RANK;
	public static boolean DM_EVENT_SCROLL_ALLOWED;
	public static boolean DM_EVENT_POTIONS_ALLOWED;
	public static boolean DM_EVENT_SUMMON_BY_ITEM_ALLOWED;
	public static List<Integer> DM_DOORS_IDS_TO_OPEN;
	public static List<Integer> DM_DOORS_IDS_TO_CLOSE;
	public static boolean DM_REWARD_PLAYERS_TIE;
	public static byte DM_EVENT_MIN_LVL;
	public static byte DM_EVENT_MAX_LVL;
	public static int DM_EVENT_EFFECTS_REMOVAL;
	public static Map<Integer, Integer> DM_EVENT_FIGHTER_BUFFS;
	public static Map<Integer, Integer> DM_EVENT_MAGE_BUFFS;
	public static String DISABLE_ID_CLASSES_STRING;
	public static List<Integer> DISABLE_ID_CLASSES;
	
	public static boolean LM_EVENT_ENABLED;
	public static String[] LM_EVENT_INTERVAL;
	public static Long LM_EVENT_PARTICIPATION_TIME;
	public static int LM_EVENT_RUNNING_TIME;
	public static String LM_NPC_LOC_NAME;
	public static int LM_EVENT_PARTICIPATION_NPC_ID;
	public static short LM_EVENT_PLAYER_CREDITS;
	public static int[] LM_EVENT_PARTICIPATION_NPC_COORDINATES = new int[4];
	public static int[] LM_EVENT_PARTICIPATION_FEE = new int[2];
	public static int LM_EVENT_MIN_PLAYERS;
	public static int LM_EVENT_MAX_PLAYERS;
	public static int LM_EVENT_RESPAWN_TELEPORT_DELAY;
	public static int LM_EVENT_START_LEAVE_TELEPORT_DELAY;
	public static List<int[]> LM_EVENT_PLAYER_COORDINATES;
	public static List<int[]> LM_EVENT_REWARDS;
	public static boolean LM_EVENT_SCROLL_ALLOWED;
	public static boolean LM_EVENT_POTIONS_ALLOWED;
	public static boolean LM_EVENT_SUMMON_BY_ITEM_ALLOWED;
	public static List<Integer> LM_DOORS_IDS_TO_OPEN;
	public static List<Integer> LM_DOORS_IDS_TO_CLOSE;
	public static boolean LM_REWARD_PLAYERS_TIE;
	public static byte LM_EVENT_MIN_LVL;
	public static byte LM_EVENT_MAX_LVL;
	public static int LM_EVENT_EFFECTS_REMOVAL;
	public static Map<Integer, Integer> LM_EVENT_FIGHTER_BUFFS;
	public static Map<Integer, Integer> LM_EVENT_MAGE_BUFFS;
	
	public static boolean TVT_EVENT_ENABLED;
	public static String[] TVT_EVENT_INTERVAL;
	public static int TVT_EVENT_PARTICIPATION_TIME;
	public static int TVT_EVENT_RUNNING_TIME;
	public static String TVT_NPC_LOC_NAME;
	public static int TVT_EVENT_PARTICIPATION_NPC_ID;
	public static int[] TVT_EVENT_PARTICIPATION_NPC_COORDINATES = new int[4];
	public static int[] TVT_EVENT_PARTICIPATION_FEE = new int[2];
	public static int TVT_EVENT_MIN_PLAYERS_IN_TEAMS;
	public static int TVT_EVENT_MAX_PLAYERS_IN_TEAMS;
	public static int TVT_EVENT_RESPAWN_TELEPORT_DELAY;
	public static int TVT_EVENT_START_LEAVE_TELEPORT_DELAY;
	public static String TVT_EVENT_TEAM_1_NAME;
	public static int[] TVT_EVENT_TEAM_1_COORDINATES = new int[3];
	public static String TVT_EVENT_TEAM_2_NAME;
	public static int[] TVT_EVENT_TEAM_2_COORDINATES = new int[3];
	public static List<int[]> TVT_EVENT_REWARDS;
	public static boolean TVT_EVENT_TARGET_TEAM_MEMBERS_ALLOWED;
	public static boolean TVT_EVENT_SCROLL_ALLOWED;
	public static boolean TVT_EVENT_POTIONS_ALLOWED;
	public static boolean TVT_EVENT_SUMMON_BY_ITEM_ALLOWED;
	public static List<Integer> TVT_DOORS_IDS_TO_OPEN;
	public static List<Integer> TVT_DOORS_IDS_TO_CLOSE;
	public static boolean TVT_REWARD_TEAM_TIE;
	public static byte TVT_EVENT_MIN_LVL;
	public static byte TVT_EVENT_MAX_LVL;
	public static int TVT_EVENT_EFFECTS_REMOVAL;
	public static Map<Integer, Integer> TVT_EVENT_FIGHTER_BUFFS;
	public static Map<Integer, Integer> TVT_EVENT_MAGE_BUFFS;
	public static boolean TVT_REWARD_PLAYER;
	public static String TVT_EVENT_ON_KILL;
	public static String DISABLE_ID_CLASSES_STRING_TVT;
	public static List<Integer> DISABLE_ID_CLASSES_TVT;
	public static boolean ALLOW_TVT_DLG;
	public static int TVT_EVENT_MAX_PARTICIPANTS_PER_IP;
	
	// --------------------------------------------------
	// GeoEngine
	// --------------------------------------------------
	
	/** Geodata */
	public static String GEODATA_PATH;
	public static GeoType GEODATA_TYPE;
	
	/** Path checking */
	public static int PART_OF_CHARACTER_HEIGHT;
	public static int MAX_OBSTACLE_HEIGHT;
	
	/** Path finding */
	public static String PATHFIND_BUFFERS;
	public static int MOVE_WEIGHT;
	public static int MOVE_WEIGHT_DIAG;
	public static int OBSTACLE_WEIGHT;
	public static int OBSTACLE_WEIGHT_DIAG;
	public static int HEURISTIC_WEIGHT;
	public static int HEURISTIC_WEIGHT_DIAG;
	public static int MAX_ITERATIONS;
	
	// --------------------------------------------------
	// HexID
	// --------------------------------------------------
	
	public static int SERVER_ID;
	public static byte[] HEX_ID;
	
	// --------------------------------------------------
	// Loginserver
	// --------------------------------------------------
	
	public static String LOGINSERVER_HOSTNAME;
	public static int LOGINSERVER_PORT;
	
	public static int LOGIN_TRY_BEFORE_BAN;
	public static int LOGIN_BLOCK_AFTER_BAN;
	public static boolean ACCEPT_NEW_GAMESERVER;
	
	public static boolean SHOW_LICENCE;
	
	public static boolean AUTO_CREATE_ACCOUNTS;
	
	public static boolean FLOOD_PROTECTION;
	public static int FAST_CONNECTION_LIMIT;
	public static int NORMAL_CONNECTION_TIME;
	public static int FAST_CONNECTION_TIME;
	public static int MAX_CONNECTION_PER_IP;
	
	// --------------------------------------------------
	// NPCs / Monsters
	// --------------------------------------------------
	
	/** Spawn */
	public static double SPAWN_MULTIPLIER;
	public static String[] SPAWN_EVENTS;
	
	/** Champion Mod */
	public static int CHAMPION_FREQUENCY;
	public static boolean CHAMPION_DEEPBLUE_DROP_RULES;
	public static int CHAMP_MIN_LVL;
	public static int CHAMP_MAX_LVL;
	public static int CHAMPION_HP;
	public static double CHAMPION_HP_REGEN;
	public static double CHAMPION_RATE_XP;
	public static double CHAMPION_RATE_SP;
	public static double PREMIUM_CHAMPION_RATE_XP;
	public static double PREMIUM_CHAMPION_RATE_SP;
	public static int CHAMPION_REWARDS;
	public static int PREMIUM_CHAMPION_REWARDS;
	public static int CHAMPION_ADENAS_REWARDS;
	public static int PREMIUM_CHAMPION_ADENAS_REWARDS;
	public static double CHAMPION_ATK;
	public static double CHAMPION_SPD_ATK;
	public static int CHAMPION_REWARD;
	public static int CHAMPION_REWARD_ID;
	public static int CHAMPION_REWARD_QTY;
	public static int CHAMPION_AURA;
	
	/** Class Master */
	public static boolean ALLOW_ENTIRE_TREE;
	public static ClassMasterSettings CLASS_MASTER_SETTINGS;
	
	/** Wedding Manager */
	public static int WEDDING_PRICE;
	public static boolean WEDDING_SAMESEX;
	public static boolean WEDDING_FORMALWEAR;
	
	/** Scheme Buffer */
	public static int BUFFER_MAX_SCHEMES;
	public static int BUFFER_STATIC_BUFF_COST;
	
	/** Wyvern Manager */
	public static int WYVERN_REQUIRED_LEVEL;
	public static int WYVERN_REQUIRED_CRYSTALS;
	
	/** Misc */
	public static boolean FREE_TELEPORT;
	public static int LVL_FREE_TELEPORT;
	public static boolean ANNOUNCE_MAMMON_SPAWN;
	public static boolean MOB_AGGRO_IN_PEACEZONE;
	public static boolean SHOW_NPC_LVL;
	public static boolean SHOW_NPC_CREST;
	public static boolean SHOW_SUMMON_CREST;
	
	/** Raid Boss */
	public static double RAID_HP_REGEN_MULTIPLIER;
	public static double RAID_MP_REGEN_MULTIPLIER;
	public static double RAID_DEFENCE_MULTIPLIER;
	public static int RAID_MINION_RESPAWN_TIMER;
	
	public static boolean RAID_DISABLE_CURSE;
	
	/** Grand Boss */
	public static int SPAWN_INTERVAL_ANTHARAS;
	public static int RANDOM_SPAWN_TIME_ANTHARAS;
	public static int WAIT_TIME_ANTHARAS;
	
	public static int SPAWN_INTERVAL_BAIUM;
	public static int RANDOM_SPAWN_TIME_BAIUM;
	
	public static int SPAWN_INTERVAL_FRINTEZZA;
	public static int RANDOM_SPAWN_TIME_FRINTEZZA;
	public static int WAIT_TIME_FRINTEZZA;
	
	public static int SPAWN_INTERVAL_SAILREN;
	public static int RANDOM_SPAWN_TIME_SAILREN;
	public static int WAIT_TIME_SAILREN;
	
	public static int SPAWN_INTERVAL_VALAKAS;
	public static int RANDOM_SPAWN_TIME_VALAKAS;
	public static int WAIT_TIME_VALAKAS;
	
	public static int SPAWN_INTERVAL_DR_CHAOS;
	public static int RANDOM_SPAWN_TIME_DR_CHAOS;
	
	// High Priestess van Halter
	public static int SPAWN_INTERVAL_HALTER;
	public static int RANDOM_SPAWN_TIME_HALTER;
	
	/** AI */
	public static boolean GUARD_ATTACK_AGGRO_MOB;
	public static int RANDOM_WALK_RATE;
	public static int MAX_DRIFT_RANGE;
	public static int MIN_NPC_ANIMATION;
	public static int MAX_NPC_ANIMATION;
	public static int MIN_MONSTER_ANIMATION;
	public static int MAX_MONSTER_ANIMATION;
	
	// --------------------------------------------------
	// Offline
	// --------------------------------------------------
	
	public static boolean OFFLINE_TRADE_ENABLE;
	public static boolean OFFLINE_CRAFT_ENABLE;
	public static boolean OFFLINE_MODE_IN_PEACE_ZONE;
	public static boolean OFFLINE_MODE_NO_DAMAGE;
	public static boolean RESTORE_OFFLINERS;
	public static int OFFLINE_MAX_DAYS;
	public static boolean OFFLINE_DISCONNECT_FINISHED;
	public static boolean OFFLINE_SLEEP_EFFECT;
	public static boolean RESTORE_STORE_ITEMS;
	
	// --------------------------------------------------
	// Players
	// --------------------------------------------------
	
	/** Misc */
	public static boolean EFFECT_CANCELING;
	public static double HP_REGEN_MULTIPLIER;
	public static double MP_REGEN_MULTIPLIER;
	public static double CP_REGEN_MULTIPLIER;
	public static int PLAYER_SPAWN_PROTECTION;
	public static int PLAYER_FAKEDEATH_UP_PROTECTION;
	public static double RESPAWN_RESTORE_HP;
	public static int MAX_PVTSTORE_SLOTS_DWARF;
	public static int MAX_PVTSTORE_SLOTS_OTHER;
	public static boolean DEEPBLUE_DROP_RULES;
	public static boolean ALLOW_DELEVEL;
	public static int DEATH_PENALTY_CHANCE;
	
	/** Inventory & WH */
	public static int INVENTORY_MAXIMUM_NO_DWARF;
	public static int INVENTORY_MAXIMUM_DWARF;
	public static int INVENTORY_MAXIMUM_PET;
	public static int MAX_ITEM_IN_PACKET;
	public static double WEIGHT_LIMIT;
	public static int WAREHOUSE_SLOTS_NO_DWARF;
	public static int WAREHOUSE_SLOTS_DWARF;
	public static int WAREHOUSE_SLOTS_CLAN;
	public static int FREIGHT_SLOTS;
	public static boolean REGION_BASED_FREIGHT;
	public static int FREIGHT_PRICE;
	
	/** Enchant */
	public static Map<Integer, Double> ENCHANT_CHANCE_WEAPON;
	public static Map<Integer, Double> ENCHANT_CHANCE_ARMOR;
	public static Map<Integer, Double> BLESSED_ENCHANT_CHANCE_WEAPON;
	public static Map<Integer, Double> BLESSED_ENCHANT_CHANCE_ARMOR;
	public static Map<Integer, Double> CRYSTAL_ENCHANT_CHANCE_WEAPON;
	public static Map<Integer, Double> CRYSTAL_ENCHANT_CHANCE_ARMOR;
	public static int ENCHANT_MAX_WEAPON;
	public static int ENCHANT_MAX_ARMOR;
	public static int ENCHANT_SAFE_MAX;
	public static int ENCHANT_SAFE_MAX_FULL;
	public static int ENCHANT_FAILED_VALUE;
	
	/** Augmentations */
	public static int AUGMENTATION_NG_SKILL_CHANCE;
	public static int AUGMENTATION_NG_GLOW_CHANCE;
	public static int AUGMENTATION_MID_SKILL_CHANCE;
	public static int AUGMENTATION_MID_GLOW_CHANCE;
	public static int AUGMENTATION_HIGH_SKILL_CHANCE;
	public static int AUGMENTATION_HIGH_GLOW_CHANCE;
	public static int AUGMENTATION_TOP_SKILL_CHANCE;
	public static int AUGMENTATION_TOP_GLOW_CHANCE;
	public static int AUGMENTATION_BASESTAT_CHANCE;
	
	/** Karma & PvP */
	public static boolean KARMA_PLAYER_CAN_SHOP;
	public static boolean KARMA_PLAYER_CAN_USE_GK;
	public static boolean KARMA_PLAYER_CAN_TELEPORT;
	public static boolean KARMA_PLAYER_CAN_TRADE;
	public static boolean KARMA_PLAYER_CAN_USE_WH;
	
	public static boolean KARMA_DROP_GM;
	public static boolean KARMA_AWARD_PK_KILL;
	public static int KARMA_PK_LIMIT;
	
	public static int[] KARMA_NONDROPPABLE_PET_ITEMS;
	public static int[] KARMA_NONDROPPABLE_ITEMS;
	
	public static int PVP_NORMAL_TIME;
	public static int PVP_PVP_TIME;
	
	/** Party */
	public static String PARTY_XP_CUTOFF_METHOD;
	public static int PARTY_XP_CUTOFF_LEVEL;
	public static double PARTY_XP_CUTOFF_PERCENT;
	public static int PARTY_RANGE;
	
	/** GMs & Admin Stuff */
	public static int DEFAULT_ACCESS_LEVEL;
	public static boolean GM_HERO_AURA;
	public static boolean GM_STARTUP_INVULNERABLE;
	public static boolean GM_STARTUP_INVISIBLE;
	public static boolean GM_STARTUP_BLOCK_ALL;
	public static boolean GM_STARTUP_AUTO_LIST;
	
	/** petitions */
	public static boolean PETITIONING_ALLOWED;
	public static int MAX_PETITIONS_PER_PLAYER;
	public static int MAX_PETITIONS_PENDING;
	
	/** Crafting **/
	public static boolean IS_CRAFTING_ENABLED;
	public static int DWARF_RECIPE_LIMIT;
	public static int COMMON_RECIPE_LIMIT;
	public static boolean BLACKSMITH_USE_RECIPES;
	
	/** Skills & Classes **/
	public static boolean AUTO_LEARN_SKILLS;
	public static int LVL_AUTO_LEARN_SKILLS;
	public static boolean MAGIC_FAILURES;
	public static int PERFECT_SHIELD_BLOCK_RATE;
	public static boolean LIFE_CRYSTAL_NEEDED;
	public static boolean SP_BOOK_NEEDED;
	public static boolean ES_SP_BOOK_NEEDED;
	public static boolean DIVINE_SP_BOOK_NEEDED;
	public static boolean SUBCLASS_WITHOUT_QUESTS;
	
	/** Buffs */
	public static boolean STORE_SKILL_COOLTIME;
	public static int MAX_BUFFS_AMOUNT;
	
	// --------------------------------------------------
	// Sieges
	// --------------------------------------------------
	
	public static int SIEGE_LENGTH;
	public static int MINIMUM_CLAN_LEVEL;
	public static int MAX_ATTACKERS_NUMBER;
	public static int MAX_DEFENDERS_NUMBER;
	public static int ATTACKERS_RESPAWN_DELAY;
	
	public static int CH_MINIMUM_CLAN_LEVEL;
	public static int CH_MAX_ATTACKERS_NUMBER;
	
	// --------------------------------------------------
	// Server
	// --------------------------------------------------
	
	public static String HOSTNAME;
	public static String GAMESERVER_HOSTNAME;
	public static int GAMESERVER_PORT;
	public static String GAMESERVER_LOGIN_HOSTNAME;
	public static int GAMESERVER_LOGIN_PORT;
	public static int REQUEST_ID;
	public static boolean ACCEPT_ALTERNATE_ID;
	public static boolean USE_BLOWFISH_CIPHER;
	
	/** Access to database */
	public static String DATABASE_URL;
	public static String DATABASE_LOGIN;
	public static String DATABASE_PASSWORD;
	public static int DATABASE_MAX_CONNECTIONS;
	
	public static String CNAME_TEMPLATE;
	public static String TITLE_TEMPLATE;
	public static String PET_NAME_TEMPLATE;
	
	/** serverList & Test */
	public static boolean SERVER_LIST_BRACKET;
	public static boolean SERVER_LIST_CLOCK;
	public static int SERVER_LIST_AGE;
	public static boolean SERVER_LIST_TESTSERVER;
	public static boolean SERVER_LIST_PVPSERVER;
	public static boolean SERVER_GMONLY;
	
	/** clients related */
	public static int DELETE_DAYS;
	public static int MAXIMUM_ONLINE_USERS;
	
	/** Auto-loot */
	public static boolean AUTO_LOOT;
	public static boolean AUTO_LOOT_HERBS;
	public static boolean AUTO_LOOT_RAID;
	
	/** Items Management */
	public static boolean ALLOW_DISCARDITEM;
	public static boolean MULTIPLE_ITEM_DROP;
	public static int HERB_AUTO_DESTROY_TIME;
	public static int ITEM_AUTO_DESTROY_TIME;
	public static int EQUIPABLE_ITEM_AUTO_DESTROY_TIME;
	public static Map<Integer, Integer> SPECIAL_ITEM_DESTROY_TIME;
	public static int PLAYER_DROPPED_ITEM_MULTIPLIER;
	
	/** Rate control */
	public static double RATE_XP;
	public static double RATE_SP;
	public static double RATE_PARTY_XP;
	public static double RATE_PARTY_SP;
	public static double RATE_DROP_CURRENCY;
	public static double RATE_DROP_ITEMS;
	public static double RATE_DROP_ITEMS_BY_RAID;
	public static double RATE_DROP_ITEMS_BY_GRAND;
	public static double RATE_DROP_SPOIL;
	
	public static double PREMIUM_RATE_XP;
	public static double PREMIUM_RATE_SP;
	public static double PREMIUM_RATE_DROP_CURRENCY;
	public static double PREMIUM_RATE_DROP_SPOIL;
	public static double PREMIUM_RATE_DROP_ITEMS;
	public static double PREMIUM_RATE_DROP_ITEMS_BY_RAID;
	public static double PREMIUM_RATE_DROP_ITEMS_BY_GRAND;
	
	public static double PREMIUM_RATE_QUEST_DROP;
	public static double PREMIUM_RATE_QUEST_REWARD;
	public static double PREMIUM_RATE_QUEST_REWARD_XP;
	public static double PREMIUM_RATE_QUEST_REWARD_SP;
	public static double PREMIUM_RATE_QUEST_REWARD_ADENA;
	
	public static double RATE_DROP_HERBS;
	public static int RATE_DROP_MANOR;
	
	public static double RATE_QUEST_DROP;
	public static double RATE_QUEST_REWARD;
	public static double RATE_QUEST_REWARD_XP;
	public static double RATE_QUEST_REWARD_SP;
	public static double RATE_QUEST_REWARD_ADENA;
	
	public static double RATE_KARMA_EXP_LOST;
	public static double RATE_SIEGE_GUARDS_PRICE;
	
	public static int PLAYER_DROP_LIMIT;
	public static int PLAYER_RATE_DROP;
	public static int PLAYER_RATE_DROP_ITEM;
	public static int PLAYER_RATE_DROP_EQUIP;
	public static int PLAYER_RATE_DROP_EQUIP_WEAPON;
	
	public static int KARMA_DROP_LIMIT;
	public static int KARMA_RATE_DROP;
	public static int KARMA_RATE_DROP_ITEM;
	public static int KARMA_RATE_DROP_EQUIP;
	public static int KARMA_RATE_DROP_EQUIP_WEAPON;
	
	public static double PET_XP_RATE;
	public static int PET_FOOD_RATE;
	public static double SINEATER_XP_RATE;
	
	/** Allow types */
	public static boolean ALLOW_FREIGHT;
	public static boolean ALLOW_WAREHOUSE;
	public static boolean ALLOW_WEAR;
	public static int WEAR_DELAY;
	public static int WEAR_PRICE;
	public static boolean ALLOW_LOTTERY;
	public static boolean ALLOW_WATER;
	public static boolean ALLOW_BOAT;
	public static boolean ALLOW_CURSED_WEAPONS;
	public static boolean ALLOW_MANOR;
	public static boolean ENABLE_FALLING_DAMAGE;
	
	/** Debug & Dev */
	public static boolean NO_SPAWNS;
	public static boolean DEVELOPER;
	public static boolean PACKET_HANDLER_DEBUG;
	
	/** Deadlock Detector */
	public static boolean DEADLOCK_DETECTOR;
	public static int DEADLOCK_CHECK_INTERVAL;
	public static boolean RESTART_ON_DEADLOCK;
	
	/** Logs */
	public static boolean LOG_CHAT;
	public static boolean LOG_ITEMS;
	public static boolean GMAUDIT;
	
	/** Community Board */
	public static boolean ENABLE_COMMUNITY_BOARD;
	public static String BBS_DEFAULT;
	
	/** Flood Protectors */
	public static int ROLL_DICE_TIME;
	public static int HERO_VOICE_TIME;
	public static int SUBCLASS_TIME;
	public static int DROP_ITEM_TIME;
	public static int SERVER_BYPASS_TIME;
	public static int MULTISELL_TIME;
	public static int MANUFACTURE_TIME;
	public static int MANOR_TIME;
	public static int SENDMAIL_TIME;
	public static int CHARACTER_SELECT_TIME;
	public static int GLOBAL_CHAT_TIME;
	public static int TRADE_CHAT_TIME;
	public static int SOCIAL_TIME;
	public static int ITEM_TIME;
	public static int ACTION_TIME;
	
	/** ThreadPool */
	public static int SCHEDULED_THREAD_POOL_COUNT;
	public static int THREADS_PER_SCHEDULED_THREAD_POOL;
	public static int INSTANT_THREAD_POOL_COUNT;
	public static int THREADS_PER_INSTANT_THREAD_POOL;
	
	/** Misc */
	public static boolean L2WALKER_PROTECTION;
	public static boolean SERVER_NEWS;
	public static int ZONE_TOWN;
	
	// --------------------------------------------------
	// Those "hidden" settings haven't configs to avoid admins to fuck their server
	// You still can experiment changing values here. But don't say I didn't warn you.
	// --------------------------------------------------
	
	/** Reserve Host on LoginServerThread */
	public static boolean RESERVE_HOST_ON_LOGIN = false; // default false
	
	/** MMO settings */
	public static int SELECTOR_SLEEP_TIME = 20; // default 20
	public static int MAX_SEND_PER_PASS = 80; // default 80
	public static int MAX_READ_PER_PASS = 80; // default 80
	public static int HELPER_BUFFER_COUNT = 20; // default 20
	
	// --------------------------------------------------
	// RUS-ACIS
	// --------------------------------------------------
	
	/** Infinity SS and Arrows */
	public static boolean INFINITY_SS;
	public static boolean INFINITY_ARROWS;
	
	/** Olympiad Period */
	public static boolean OLY_USE_CUSTOM_PERIOD_SETTINGS;
	public static OlympiadPeriod OLY_PERIOD;
	public static int OLY_PERIOD_MULTIPLIER;
	
	public static boolean ENABLE_MODIFY_SKILL_DURATION;
	public static HashMap<Integer, Integer> SKILL_DURATION_LIST;
	
	public static String GLOBAL_CHAT;
	public static String TRADE_CHAT;
	public static int CHAT_ALL_LEVEL;
	public static int CHAT_TELL_LEVEL;
	public static int CHAT_SHOUT_LEVEL;
	public static int CHAT_TRADE_LEVEL;
	
	public static boolean ENABLE_MENU;
	public static boolean ENABLE_ONLINE_COMMAND;
	
	public static boolean BOTS_PREVENTION;
	public static int KILLS_COUNTER;
	public static int KILLS_COUNTER_RANDOMIZATION;
	public static int VALIDATION_TIME;
	public static int PUNISHMENT;
	public static int PUNISHMENT_TIME;
	
	public static boolean USE_PREMIUM_SERVICE;
	public static boolean ALTERNATE_DROP_LIST;
	public static boolean ENABLE_SKIPPING;
	
	public static boolean ATTACK_PTS;
	public static boolean SUBCLASS_SKILLS;
	public static boolean GAME_SUBCLASS_EVERYWHERE;
	
	public static boolean SHOW_NPC_INFO;
	public static boolean ALLOW_GRAND_BOSSES_TELEPORT;
	
	// chatfilter
	public static List<String> FILTER_LIST;
	
	public static boolean USE_SAY_FILTER;
	public static String CHAT_FILTER_CHARS;
	
	public static boolean CABAL_BUFFER;
	public static boolean SUPER_HASTE;
	
	public static String RESTRICTED_CHAR_NAMES;
	public static List<String> LIST_RESTRICTED_CHAR_NAMES = new ArrayList<>();
	
	public static int FAKE_ONLINE_AMOUNT;
	
	public static String BUFFS_CATEGORY;
	public static ArrayList<String> PREMIUM_BUFFS_CATEGORY = new ArrayList<>();
	
	public static boolean ANTIFEED_ENABLE;
	public static boolean ANTIFEED_DUALBOX;
	public static boolean ANTIFEED_DISCONNECTED_AS_DUALBOX;
	public static int ANTIFEED_INTERVAL;
	
	public static int DUALBOX_CHECK_MAX_PLAYERS_PER_IP;
	public static int DUALBOX_CHECK_MAX_OLYMPIAD_PARTICIPANTS_PER_IP;
	public static Map<Integer, Integer> DUALBOX_CHECK_WHITELIST;
	
	public static List<Integer> AUTO_LOOT_ITEM_IDS;
	
	/**
	 * Initialize {@link ExProperties} from specified configuration file.
	 * @param filename : File name to be loaded.
	 * @return ExProperties : Initialized {@link ExProperties}.
	 */
	public static final ExProperties initProperties(String filename)
	{
		final ExProperties result = new ExProperties();
		
		try
		{
			result.load(new File(filename));
		}
		catch (Exception e)
		{
			LOGGER.error("An error occured loading '{}' config.", e, filename);
		}
		
		return result;
	}
	
	/**
	 * Loads offline shop settings
	 */
	private static final void loadOfflineShop()
	{
		final ExProperties offline = initProperties(OFFLINE_FILE);
		OFFLINE_TRADE_ENABLE = offline.getProperty("OfflineTradeEnable", false);
		OFFLINE_CRAFT_ENABLE = offline.getProperty("OfflineCraftEnable", false);
		OFFLINE_MODE_IN_PEACE_ZONE = offline.getProperty("OfflineModeInPeaceZone", false);
		OFFLINE_MODE_NO_DAMAGE = offline.getProperty("OfflineModeNoDamage", false);
		RESTORE_OFFLINERS = offline.getProperty("RestoreOffliners", false);
		OFFLINE_MAX_DAYS = offline.getProperty("OfflineMaxDays", 10);
		OFFLINE_DISCONNECT_FINISHED = offline.getProperty("OfflineDisconnectFinished", true);
		OFFLINE_SLEEP_EFFECT = offline.getProperty("OfflineSleepEffect", true);
		RESTORE_STORE_ITEMS = offline.getProperty("RestoreStoreItems", false);
	}
	
	/**
	 * Loads clan and clan hall settings.
	 */
	private static final void loadClans()
	{
		final ExProperties clans = initProperties(CLANS_FILE);
		
		CLAN_JOIN_DAYS = clans.getProperty("DaysBeforeJoinAClan", 5);
		CLAN_CREATE_DAYS = clans.getProperty("DaysBeforeCreateAClan", 10);
		MAX_NUM_OF_CLANS_IN_ALLY = clans.getProperty("MaxNumOfClansInAlly", 3);
		CLAN_MEMBERS_FOR_WAR = clans.getProperty("ClanMembersForWar", 15);
		CLAN_WAR_PENALTY_WHEN_ENDED = clans.getProperty("ClanWarPenaltyWhenEnded", 5);
		CLAN_DISSOLVE_DAYS = clans.getProperty("DaysToPassToDissolveAClan", 7);
		ALLY_JOIN_DAYS_WHEN_LEAVED = clans.getProperty("DaysBeforeJoinAllyWhenLeaved", 1);
		ALLY_JOIN_DAYS_WHEN_DISMISSED = clans.getProperty("DaysBeforeJoinAllyWhenDismissed", 1);
		ACCEPT_CLAN_DAYS_WHEN_DISMISSED = clans.getProperty("DaysBeforeAcceptNewClanWhenDismissed", 1);
		CREATE_ALLY_DAYS_WHEN_DISSOLVED = clans.getProperty("DaysBeforeCreateNewAllyWhenDissolved", 10);
		MEMBERS_CAN_WITHDRAW_FROM_CLANWH = clans.getProperty("MembersCanWithdrawFromClanWH", false);
		
		MANOR_REFRESH_TIME = clans.getProperty("ManorRefreshTime", 20);
		MANOR_REFRESH_MIN = clans.getProperty("ManorRefreshMin", 0);
		MANOR_APPROVE_TIME = clans.getProperty("ManorApproveTime", 6);
		MANOR_APPROVE_MIN = clans.getProperty("ManorApproveMin", 0);
		MANOR_MAINTENANCE_MIN = clans.getProperty("ManorMaintenanceMin", 6);
		MANOR_SAVE_PERIOD_RATE = clans.getProperty("ManorSavePeriodRate", 2) * 3600000;
		
		CH_TELE_FEE_RATIO = clans.getProperty("ClanHallTeleportFunctionFeeRatio", 86400000L);
		CH_TELE1_FEE = clans.getProperty("ClanHallTeleportFunctionFeeLvl1", 7000);
		CH_TELE2_FEE = clans.getProperty("ClanHallTeleportFunctionFeeLvl2", 14000);
		CH_SUPPORT_FEE_RATIO = clans.getProperty("ClanHallSupportFunctionFeeRatio", 86400000L);
		CH_SUPPORT1_FEE = clans.getProperty("ClanHallSupportFeeLvl1", 17500);
		CH_SUPPORT2_FEE = clans.getProperty("ClanHallSupportFeeLvl2", 35000);
		CH_SUPPORT3_FEE = clans.getProperty("ClanHallSupportFeeLvl3", 49000);
		CH_SUPPORT4_FEE = clans.getProperty("ClanHallSupportFeeLvl4", 77000);
		CH_SUPPORT5_FEE = clans.getProperty("ClanHallSupportFeeLvl5", 147000);
		CH_SUPPORT6_FEE = clans.getProperty("ClanHallSupportFeeLvl6", 252000);
		CH_SUPPORT7_FEE = clans.getProperty("ClanHallSupportFeeLvl7", 259000);
		CH_SUPPORT8_FEE = clans.getProperty("ClanHallSupportFeeLvl8", 364000);
		CH_MPREG_FEE_RATIO = clans.getProperty("ClanHallMpRegenerationFunctionFeeRatio", 86400000L);
		CH_MPREG1_FEE = clans.getProperty("ClanHallMpRegenerationFeeLvl1", 14000);
		CH_MPREG2_FEE = clans.getProperty("ClanHallMpRegenerationFeeLvl2", 26250);
		CH_MPREG3_FEE = clans.getProperty("ClanHallMpRegenerationFeeLvl3", 45500);
		CH_MPREG4_FEE = clans.getProperty("ClanHallMpRegenerationFeeLvl4", 96250);
		CH_MPREG5_FEE = clans.getProperty("ClanHallMpRegenerationFeeLvl5", 140000);
		CH_HPREG_FEE_RATIO = clans.getProperty("ClanHallHpRegenerationFunctionFeeRatio", 86400000L);
		CH_HPREG1_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl1", 4900);
		CH_HPREG2_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl2", 5600);
		CH_HPREG3_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl3", 7000);
		CH_HPREG4_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl4", 8166);
		CH_HPREG5_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl5", 10500);
		CH_HPREG6_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl6", 12250);
		CH_HPREG7_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl7", 14000);
		CH_HPREG8_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl8", 15750);
		CH_HPREG9_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl9", 17500);
		CH_HPREG10_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl10", 22750);
		CH_HPREG11_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl11", 26250);
		CH_HPREG12_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl12", 29750);
		CH_HPREG13_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl13", 36166);
		CH_EXPREG_FEE_RATIO = clans.getProperty("ClanHallExpRegenerationFunctionFeeRatio", 86400000L);
		CH_EXPREG1_FEE = clans.getProperty("ClanHallExpRegenerationFeeLvl1", 21000);
		CH_EXPREG2_FEE = clans.getProperty("ClanHallExpRegenerationFeeLvl2", 42000);
		CH_EXPREG3_FEE = clans.getProperty("ClanHallExpRegenerationFeeLvl3", 63000);
		CH_EXPREG4_FEE = clans.getProperty("ClanHallExpRegenerationFeeLvl4", 105000);
		CH_EXPREG5_FEE = clans.getProperty("ClanHallExpRegenerationFeeLvl5", 147000);
		CH_EXPREG6_FEE = clans.getProperty("ClanHallExpRegenerationFeeLvl6", 163331);
		CH_EXPREG7_FEE = clans.getProperty("ClanHallExpRegenerationFeeLvl7", 210000);
		CH_ITEM_FEE_RATIO = clans.getProperty("ClanHallItemCreationFunctionFeeRatio", 86400000L);
		CH_ITEM1_FEE = clans.getProperty("ClanHallItemCreationFunctionFeeLvl1", 210000);
		CH_ITEM2_FEE = clans.getProperty("ClanHallItemCreationFunctionFeeLvl2", 490000);
		CH_ITEM3_FEE = clans.getProperty("ClanHallItemCreationFunctionFeeLvl3", 980000);
		CH_CURTAIN_FEE_RATIO = clans.getProperty("ClanHallCurtainFunctionFeeRatio", 86400000L);
		CH_CURTAIN1_FEE = clans.getProperty("ClanHallCurtainFunctionFeeLvl1", 2002);
		CH_CURTAIN2_FEE = clans.getProperty("ClanHallCurtainFunctionFeeLvl2", 2625);
		CH_FRONT_FEE_RATIO = clans.getProperty("ClanHallFrontPlatformFunctionFeeRatio", 86400000L);
		CH_FRONT1_FEE = clans.getProperty("ClanHallFrontPlatformFunctionFeeLvl1", 3031);
		CH_FRONT2_FEE = clans.getProperty("ClanHallFrontPlatformFunctionFeeLvl2", 9331);
		
		CS_TELE_FEE_RATIO = clans.getProperty("CastleTeleportFunctionFeeRatio", 604800000L);
		CS_TELE1_FEE = clans.getProperty("CastleTeleportFunctionFeeLvl1", 7000);
		CS_TELE2_FEE = clans.getProperty("CastleTeleportFunctionFeeLvl2", 14000);
		CS_SUPPORT_FEE_RATIO = clans.getProperty("CastleSupportFunctionFeeRatio", 86400000L);
		CS_SUPPORT1_FEE = clans.getProperty("CastleSupportFeeLvl1", 7000);
		CS_SUPPORT2_FEE = clans.getProperty("CastleSupportFeeLvl2", 21000);
		CS_SUPPORT3_FEE = clans.getProperty("CastleSupportFeeLvl3", 37000);
		CS_SUPPORT4_FEE = clans.getProperty("CastleSupportFeeLvl4", 52000);
		CS_MPREG_FEE_RATIO = clans.getProperty("CastleMpRegenerationFunctionFeeRatio", 86400000L);
		CS_MPREG1_FEE = clans.getProperty("CastleMpRegenerationFeeLvl1", 2000);
		CS_MPREG2_FEE = clans.getProperty("CastleMpRegenerationFeeLvl2", 6500);
		CS_MPREG3_FEE = clans.getProperty("CastleMpRegenerationFeeLvl3", 13750);
		CS_MPREG4_FEE = clans.getProperty("CastleMpRegenerationFeeLvl4", 20000);
		CS_HPREG_FEE_RATIO = clans.getProperty("CastleHpRegenerationFunctionFeeRatio", 86400000L);
		CS_HPREG1_FEE = clans.getProperty("CastleHpRegenerationFeeLvl1", 1000);
		CS_HPREG2_FEE = clans.getProperty("CastleHpRegenerationFeeLvl2", 1500);
		CS_HPREG3_FEE = clans.getProperty("CastleHpRegenerationFeeLvl3", 2250);
		CS_HPREG4_FEE = clans.getProperty("CastleHpRegenerationFeeLvl4", 3270);
		CS_HPREG5_FEE = clans.getProperty("CastleHpRegenerationFeeLvl5", 5166);
		CS_EXPREG_FEE_RATIO = clans.getProperty("CastleExpRegenerationFunctionFeeRatio", 86400000L);
		CS_EXPREG1_FEE = clans.getProperty("CastleExpRegenerationFeeLvl1", 9000);
		CS_EXPREG2_FEE = clans.getProperty("CastleExpRegenerationFeeLvl2", 15000);
		CS_EXPREG3_FEE = clans.getProperty("CastleExpRegenerationFeeLvl3", 21000);
		CS_EXPREG4_FEE = clans.getProperty("CastleExpRegenerationFeeLvl4", 30000);
	}
	
	/**
	 * Loads event settings.<br>
	 * Such as olympiad, seven signs festival, four sepulchures, dimensional rift, weddings, lottery, fishing championship.
	 */
	private static final void loadEvents()
	{
		final ExProperties events = initProperties(EVENTS_FILE);
		
		OLY_START_TIME = events.getProperty("OlyStartTime", 18);
		OLY_MIN = events.getProperty("OlyMin", 0);
		OLY_CPERIOD = events.getProperty("OlyCPeriod", 21600000L);
		OLY_BATTLE = events.getProperty("OlyBattle", 180000L);
		OLY_WPERIOD = events.getProperty("OlyWPeriod", 604800000L);
		OLY_VPERIOD = events.getProperty("OlyVPeriod", 86400000L);
		OLY_WAIT_TIME = events.getProperty("OlyWaitTime", 30);
		OLY_WAIT_BATTLE = events.getProperty("OlyWaitBattle", 60);
		OLY_WAIT_END = events.getProperty("OlyWaitEnd", 40);
		OLY_START_POINTS = events.getProperty("OlyStartPoints", 18);
		OLY_WEEKLY_POINTS = events.getProperty("OlyWeeklyPoints", 3);
		OLY_MIN_MATCHES = events.getProperty("OlyMinMatchesToBeClassed", 5);
		OLY_CLASSED = events.getProperty("OlyClassedParticipants", 5);
		OLY_NONCLASSED = events.getProperty("OlyNonClassedParticipants", 9);
		OLY_CLASSED_REWARD = events.parseIntIntList("OlyClassedReward", "6651-50");
		OLY_NONCLASSED_REWARD = events.parseIntIntList("OlyNonClassedReward", "6651-30");
		OLY_GP_PER_POINT = events.getProperty("OlyGPPerPoint", 1000);
		OLY_HERO_POINTS = events.getProperty("OlyHeroPoints", 300);
		OLY_RANK1_POINTS = events.getProperty("OlyRank1Points", 100);
		OLY_RANK2_POINTS = events.getProperty("OlyRank2Points", 75);
		OLY_RANK3_POINTS = events.getProperty("OlyRank3Points", 55);
		OLY_RANK4_POINTS = events.getProperty("OlyRank4Points", 40);
		OLY_RANK5_POINTS = events.getProperty("OlyRank5Points", 30);
		OLY_MAX_POINTS = events.getProperty("OlyMaxPoints", 10);
		OLY_DIVIDER_CLASSED = events.getProperty("OlyDividerClassed", 3);
		OLY_DIVIDER_NON_CLASSED = events.getProperty("OlyDividerNonClassed", 5);
		OLY_ANNOUNCE_GAMES = events.getProperty("OlyAnnounceGames", true);
		OLY_ENCHANT_LIMIT = events.getProperty("OlyMaxEnchant", -1);
		
		SEVEN_SIGNS_BYPASS_PREREQUISITES = events.getProperty("SevenSignsBypassPrerequisites", false);
		FESTIVAL_MIN_PLAYER = MathUtil.limit(events.getProperty("FestivalMinPlayer", 5), 2, 9);
		MAXIMUM_PLAYER_CONTRIB = events.getProperty("MaxPlayerContrib", 1000000);
		FESTIVAL_MANAGER_START = events.getProperty("FestivalManagerStart", 120000L);
		FESTIVAL_LENGTH = events.getProperty("FestivalLength", 1080000L);
		FESTIVAL_CYCLE_LENGTH = events.getProperty("FestivalCycleLength", 2280000L);
		FESTIVAL_FIRST_SPAWN = events.getProperty("FestivalFirstSpawn", 120000L);
		FESTIVAL_FIRST_SWARM = events.getProperty("FestivalFirstSwarm", 300000L);
		FESTIVAL_SECOND_SPAWN = events.getProperty("FestivalSecondSpawn", 540000L);
		FESTIVAL_SECOND_SWARM = events.getProperty("FestivalSecondSwarm", 720000L);
		FESTIVAL_CHEST_SPAWN = events.getProperty("FestivalChestSpawn", 900000L);
		
		FS_TIME_ENTRY = events.getProperty("EntryTime", 55);
		FS_TIME_END = events.getProperty("EndTime", 50);
		FS_PARTY_MEMBER_COUNT = MathUtil.limit(events.getProperty("NeededPartyMembers", 4), 2, 9);
		
		RIFT_MIN_PARTY_SIZE = events.getProperty("RiftMinPartySize", 2);
		RIFT_MAX_JUMPS = events.getProperty("MaxRiftJumps", 4);
		RIFT_SPAWN_DELAY = events.getProperty("RiftSpawnDelay", 10000);
		RIFT_AUTO_JUMPS_TIME_MIN = events.getProperty("AutoJumpsDelayMin", 480);
		RIFT_AUTO_JUMPS_TIME_MAX = events.getProperty("AutoJumpsDelayMax", 600);
		RIFT_ENTER_COST_RECRUIT = events.getProperty("RecruitCost", 18);
		RIFT_ENTER_COST_SOLDIER = events.getProperty("SoldierCost", 21);
		RIFT_ENTER_COST_OFFICER = events.getProperty("OfficerCost", 24);
		RIFT_ENTER_COST_CAPTAIN = events.getProperty("CaptainCost", 27);
		RIFT_ENTER_COST_COMMANDER = events.getProperty("CommanderCost", 30);
		RIFT_ENTER_COST_HERO = events.getProperty("HeroCost", 33);
		RIFT_BOSS_ROOM_TIME_MULTIPLY = events.getProperty("BossRoomTimeMultiply", 1.);
		
		LOTTERY_PRIZE = events.getProperty("LotteryPrize", 50000);
		LOTTERY_TICKET_PRICE = events.getProperty("LotteryTicketPrice", 2000);
		LOTTERY_5_NUMBER_RATE = events.getProperty("Lottery5NumberRate", 0.6);
		LOTTERY_4_NUMBER_RATE = events.getProperty("Lottery4NumberRate", 0.2);
		LOTTERY_3_NUMBER_RATE = events.getProperty("Lottery3NumberRate", 0.2);
		LOTTERY_2_AND_1_NUMBER_PRIZE = events.getProperty("Lottery2and1NumberPrize", 200);
		
		ALLOW_FISH_CHAMPIONSHIP = events.getProperty("AllowFishChampionship", true);
		FISH_CHAMPIONSHIP_REWARD_ITEM = events.getProperty("FishChampionshipRewardItemId", 57);
		FISH_CHAMPIONSHIP_REWARD_1 = events.getProperty("FishChampionshipReward1", 800000);
		FISH_CHAMPIONSHIP_REWARD_2 = events.getProperty("FishChampionshipReward2", 500000);
		FISH_CHAMPIONSHIP_REWARD_3 = events.getProperty("FishChampionshipReward3", 300000);
		FISH_CHAMPIONSHIP_REWARD_4 = events.getProperty("FishChampionshipReward4", 200000);
		FISH_CHAMPIONSHIP_REWARD_5 = events.getProperty("FishChampionshipReward5", 100000);
		
		EVENT_MEDAL_COUNT = events.getProperty("EventMedalCount", 1);
		EVENT_MEDAL_CHANCE = events.getProperty("EventMedalChance", 40);
		
		GLITTERING_MEDAL_COUNT = events.getProperty("GlitteringMedalCount", 1);
		GLITTERING_MEDAL_CHANCE = events.getProperty("GlitteringMedalChance", 2);
		
		STAR_CHANCE = events.getProperty("StarChance", 20);
		BEAD_CHANCE = events.getProperty("BeadChance", 20);
		FIR_CHANCE = events.getProperty("FirChance", 50);
		FLOWER_CHANCE = events.getProperty("FlowerChance", 5);
		
		STAR_COUNT = events.getProperty("StarCount", 1);
		BEAD_COUNT = events.getProperty("BeadCount", 1);
		FIR_COUNT = events.getProperty("FirCount", 1);
		FLOWER_COUNT = events.getProperty("FlowerCount", 1);
		
		EVENT_COMMANDS = events.getProperty("AllowEventCommands", false);
		
		CTF_EVENT_ENABLED = events.getProperty("CTFEventEnabled", false);
		CTF_EVENT_INTERVAL = events.getProperty("CTFEventInterval", "20:00").split(",");
		CTF_EVENT_PARTICIPATION_TIME = events.getProperty("CTFEventParticipationTime", 3600);
		CTF_EVENT_RUNNING_TIME = events.getProperty("CTFEventRunningTime", 1800);
		CTF_NPC_LOC_NAME = events.getProperty("CTFNpcLocName", "Giran Town");
		CTF_EVENT_PARTICIPATION_NPC_ID = events.getProperty("CTFEventParticipationNpcId", 0);
		CTF_EVENT_TEAM_1_HEADQUARTERS_ID = events.getProperty("CTFEventFirstTeamHeadquartersId", 0);
		CTF_EVENT_TEAM_2_HEADQUARTERS_ID = events.getProperty("CTFEventSecondTeamHeadquartersId", 0);
		CTF_EVENT_TEAM_1_FLAG = events.getProperty("CTFEventFirstTeamFlag", 0);
		CTF_EVENT_TEAM_2_FLAG = events.getProperty("CTFEventSecondTeamFlag", 0);
		CTF_EVENT_CAPTURE_SKILL = events.getProperty("CTFEventCaptureSkillId", 0);
		
		if (CTF_EVENT_PARTICIPATION_NPC_ID == 0)
		{
			CTF_EVENT_ENABLED = false;
			LOGGER.warn("CTFEventEngine[Config.load()]: invalid config property -> CTFEventParticipationNpcId");
		}
		else
		{
			String[] ctfNpcCoords = events.getProperty("CTFEventParticipationNpcCoordinates", "0,0,0").split(",");
			if (ctfNpcCoords.length < 3)
			{
				CTF_EVENT_ENABLED = false;
				LOGGER.warn("CTFEventEngine[Config.load()]: invalid config property -> CTFEventParticipationNpcCoordinates");
			}
			else
			{
				CTF_EVENT_PARTICIPATION_NPC_COORDINATES = new int[4];
				CTF_EVENT_PARTICIPATION_NPC_COORDINATES[0] = Integer.parseInt(ctfNpcCoords[0]);
				CTF_EVENT_PARTICIPATION_NPC_COORDINATES[1] = Integer.parseInt(ctfNpcCoords[1]);
				CTF_EVENT_PARTICIPATION_NPC_COORDINATES[2] = Integer.parseInt(ctfNpcCoords[2]);
				if (ctfNpcCoords.length == 4)
					CTF_EVENT_PARTICIPATION_NPC_COORDINATES[3] = Integer.parseInt(ctfNpcCoords[3]);
				
				CTF_EVENT_REWARDS = new ArrayList<>();
				CTF_DOORS_IDS_TO_OPEN = new ArrayList<>();
				CTF_DOORS_IDS_TO_CLOSE = new ArrayList<>();
				CTF_EVENT_TEAM_1_COORDINATES = new int[3];
				CTF_EVENT_TEAM_2_COORDINATES = new int[3];
				
				CTF_EVENT_MIN_PLAYERS_IN_TEAMS = events.getProperty("CTFEventMinPlayersInTeams", 1);
				CTF_EVENT_MAX_PLAYERS_IN_TEAMS = events.getProperty("CTFEventMaxPlayersInTeams", 20);
				CTF_EVENT_MIN_LVL = Byte.parseByte(events.getProperty("CTFEventMinPlayerLevel", "1"));
				CTF_EVENT_MAX_LVL = Byte.parseByte(events.getProperty("CTFEventMaxPlayerLevel", "80"));
				CTF_EVENT_RESPAWN_TELEPORT_DELAY = events.getProperty("CTFEventRespawnTeleportDelay", 20);
				CTF_EVENT_START_LEAVE_TELEPORT_DELAY = events.getProperty("CTFEventStartLeaveTeleportDelay", 20);
				CTF_EVENT_EFFECTS_REMOVAL = events.getProperty("CTFEventEffectsRemoval", 0);
				CTF_EVENT_TEAM_1_NAME = events.getProperty("CTFEventTeam1Name", "Team1");
				CTF_EVENT_TEAM_2_NAME = events.getProperty("CTFEventTeam2Name", "Team2");
				ctfNpcCoords = events.getProperty("CTFEventTeam1Coordinates", "0,0,0").split(",");
				if (ctfNpcCoords.length < 3)
				{
					CTF_EVENT_ENABLED = false;
					LOGGER.warn("CTFEventEngine[Config.load()]: invalid config property -> CTFEventTeam1Coordinates");
				}
				else
				{
					CTF_EVENT_TEAM_1_COORDINATES[0] = Integer.parseInt(ctfNpcCoords[0]);
					CTF_EVENT_TEAM_1_COORDINATES[1] = Integer.parseInt(ctfNpcCoords[1]);
					CTF_EVENT_TEAM_1_COORDINATES[2] = Integer.parseInt(ctfNpcCoords[2]);
					ctfNpcCoords = events.getProperty("CTFEventTeam2Coordinates", "0,0,0").split(",");
					if (ctfNpcCoords.length < 3)
					{
						CTF_EVENT_ENABLED = false;
						LOGGER.warn("CTFEventEngine[Config.load()]: invalid config property -> CTFEventTeam2Coordinates");
					}
					else
					{
						CTF_EVENT_TEAM_2_COORDINATES[0] = Integer.parseInt(ctfNpcCoords[0]);
						CTF_EVENT_TEAM_2_COORDINATES[1] = Integer.parseInt(ctfNpcCoords[1]);
						CTF_EVENT_TEAM_2_COORDINATES[2] = Integer.parseInt(ctfNpcCoords[2]);
						
						if (CTF_EVENT_TEAM_1_HEADQUARTERS_ID == 0)
						{
							CTF_EVENT_ENABLED = false;
							LOGGER.warn("CTFEventEngine[Config.load()]: invalid config property -> CTFEventFirstTeamHeadquartersId");
						}
						else
						{
							ctfNpcCoords = events.getProperty("CTFEventTeam1FlagCoordinates", "0,0,0").split(",");
							if (ctfNpcCoords.length < 3)
							{
								CTF_EVENT_ENABLED = false;
								LOGGER.warn("CTFEventEngine[Config.load()]: invalid config property -> CTFEventTeam1FlagCoordinates");
							}
							else
							{
								CTF_EVENT_TEAM_1_FLAG_COORDINATES = new int[4];
								CTF_EVENT_TEAM_1_FLAG_COORDINATES[0] = Integer.parseInt(ctfNpcCoords[0]);
								CTF_EVENT_TEAM_1_FLAG_COORDINATES[1] = Integer.parseInt(ctfNpcCoords[1]);
								CTF_EVENT_TEAM_1_FLAG_COORDINATES[2] = Integer.parseInt(ctfNpcCoords[2]);
								if (ctfNpcCoords.length == 4)
									CTF_EVENT_TEAM_1_FLAG_COORDINATES[3] = Integer.parseInt(ctfNpcCoords[3]);
							}
							
							if (CTF_EVENT_TEAM_2_HEADQUARTERS_ID == 0)
							{
								CTF_EVENT_ENABLED = false;
								LOGGER.warn("CTFEventEngine[Config.load()]: invalid config property -> CTFEventSecondTeamHeadquartersId");
							}
							else
							{
								ctfNpcCoords = events.getProperty("CTFEventTeam2FlagCoordinates", "0,0,0").split(",");
								if (ctfNpcCoords.length < 3)
								{
									CTF_EVENT_ENABLED = false;
									LOGGER.warn("CTFEventEngine[Config.load()]: invalid config property -> CTFEventTeam2FlagCoordinates");
								}
								else
								{
									CTF_EVENT_TEAM_2_FLAG_COORDINATES = new int[4];
									CTF_EVENT_TEAM_2_FLAG_COORDINATES[0] = Integer.parseInt(ctfNpcCoords[0]);
									CTF_EVENT_TEAM_2_FLAG_COORDINATES[1] = Integer.parseInt(ctfNpcCoords[1]);
									CTF_EVENT_TEAM_2_FLAG_COORDINATES[2] = Integer.parseInt(ctfNpcCoords[2]);
									if (ctfNpcCoords.length == 4)
										CTF_EVENT_TEAM_2_FLAG_COORDINATES[3] = Integer.parseInt(ctfNpcCoords[3]);
								}
								
								ctfNpcCoords = events.getProperty("CTFEventParticipationFee", "0,0").split(",");
								try
								{
									CTF_EVENT_PARTICIPATION_FEE[0] = Integer.parseInt(ctfNpcCoords[0]);
									CTF_EVENT_PARTICIPATION_FEE[1] = Integer.parseInt(ctfNpcCoords[1]);
								}
								catch (NumberFormatException nfe)
								{
									if (ctfNpcCoords.length > 0)
										LOGGER.warn("CTFEventEngine[Config.load()]: invalid config property -> CTFEventParticipationFee");
								}
								ctfNpcCoords = events.getProperty("CTFEventReward", "57,100000").split(";");
								for (String reward : ctfNpcCoords)
								{
									String[] rewardSplit = reward.split(",");
									if (rewardSplit.length != 2)
										LOGGER.warn("CTFEventEngine[Config.load()]: invalid config property -> CTFEventReward");
									else
									{
										try
										{
											CTF_EVENT_REWARDS.add(new int[]
											{
												Integer.parseInt(rewardSplit[0]),
												Integer.parseInt(rewardSplit[1])
											});
										}
										catch (NumberFormatException nfe)
										{
											if (!reward.isEmpty())
											{
												LOGGER.warn("CTFEventEngine[Config.load()]: invalid config property -> CTFEventReward");
											}
										}
									}
								}
							}
						}
						
						CTF_EVENT_TARGET_TEAM_MEMBERS_ALLOWED = events.getProperty("CTFEventTargetTeamMembersAllowed", true);
						CTF_EVENT_SCROLL_ALLOWED = events.getProperty("CTFEventScrollsAllowed", false);
						CTF_EVENT_POTIONS_ALLOWED = events.getProperty("CTFEventPotionsAllowed", false);
						CTF_EVENT_SUMMON_BY_ITEM_ALLOWED = events.getProperty("CTFEventSummonByItemAllowed", false);
						CTF_REWARD_TEAM_TIE = events.getProperty("CTFRewardTeamTie", false);
						ctfNpcCoords = events.getProperty("CTFDoorsToOpen", "").split(";");
						for (String door : ctfNpcCoords)
						{
							try
							{
								CTF_DOORS_IDS_TO_OPEN.add(Integer.parseInt(door));
							}
							catch (NumberFormatException nfe)
							{
								if (!door.isEmpty())
									LOGGER.warn("CTFEventEngine[Config.load()]: invalid config property -> CTFDoorsToOpen");
							}
						}
						
						ctfNpcCoords = events.getProperty("CTFDoorsToClose", "").split(";");
						for (String door : ctfNpcCoords)
						{
							try
							{
								CTF_DOORS_IDS_TO_CLOSE.add(Integer.parseInt(door));
							}
							catch (NumberFormatException nfe)
							{
								if (!door.isEmpty())
									LOGGER.warn("CTFEventEngine[Config.load()]: invalid config property -> CTFDoorsToClose");
							}
						}
						
						ctfNpcCoords = events.getProperty("CTFEventFighterBuffs", "").split(";");
						if (!ctfNpcCoords[0].isEmpty())
						{
							CTF_EVENT_FIGHTER_BUFFS = new HashMap<>(ctfNpcCoords.length);
							for (String skill : ctfNpcCoords)
							{
								String[] skillSplit = skill.split(",");
								if (skillSplit.length != 2)
									LOGGER.warn("CTFEventEngine[Config.load()]: invalid config property -> CTFEventFighterBuffs");
								else
								{
									try
									{
										CTF_EVENT_FIGHTER_BUFFS.put(Integer.parseInt(skillSplit[0]), Integer.parseInt(skillSplit[1]));
									}
									catch (NumberFormatException nfe)
									{
										if (!skill.isEmpty())
											LOGGER.warn("CTFEventEngine[Config.load()]: invalid config property -> CTFEventFighterBuffs");
									}
								}
							}
						}
						
						ctfNpcCoords = events.getProperty("CTFEventMageBuffs", "").split(";");
						if (!ctfNpcCoords[0].isEmpty())
						{
							CTF_EVENT_MAGE_BUFFS = new HashMap<>(ctfNpcCoords.length);
							for (String skill : ctfNpcCoords)
							{
								String[] skillSplit = skill.split(",");
								if (skillSplit.length != 2)
								{
									LOGGER.warn("CTFEventEngine[Config.load()]: invalid config property -> CTFEventMageBuffs");
								}
								else
								{
									try
									{
										CTF_EVENT_MAGE_BUFFS.put(Integer.parseInt(skillSplit[0]), Integer.parseInt(skillSplit[1]));
									}
									catch (NumberFormatException nfe)
									{
										if (!skill.isEmpty())
											LOGGER.warn("CTFEventEngine[Config.load()]: invalid config property -> CTFEventMageBuffs");
									}
								}
							}
						}
					}
				}
			}
		}
		
		DM_EVENT_ENABLED = events.getProperty("DMEventEnabled", false);
		DM_EVENT_INTERVAL = events.getProperty("DMEventInterval", "8:00,14:00,20:00,2:00").split(",");
		String[] timeParticipation = events.getProperty("DMEventParticipationTime", "01:00:00").split(":");
		Long timeDM = 0L;
		timeDM += Long.parseLong(timeParticipation[0]) * 3600L;
		timeDM += Long.parseLong(timeParticipation[1]) * 60L;
		timeDM += Long.parseLong(timeParticipation[2]);
		DM_EVENT_PARTICIPATION_TIME = timeDM * 1000L;
		DM_EVENT_RUNNING_TIME = events.getProperty("DMEventRunningTime", 1800);
		DM_NPC_LOC_NAME = events.getProperty("DMNpcLocName", "Giran Town");
		DM_EVENT_PARTICIPATION_NPC_ID = events.getProperty("DMEventParticipationNpcId", 0);
		DM_SHOW_TOP_RANK = events.getProperty("DMShowTopRank", false);
		DM_TOP_RANK = events.getProperty("DMTopRank", 10);
		if (DM_EVENT_PARTICIPATION_NPC_ID == 0)
		{
			DM_EVENT_ENABLED = false;
			LOGGER.warn("DMEventEngine[Config.load()]: invalid config property -> DMEventParticipationNpcId");
		}
		else
		{
			String[] propertySplit = events.getProperty("DMEventParticipationNpcCoordinates", "0,0,0").split(",");
			if (propertySplit.length < 3)
			{
				DM_EVENT_ENABLED = false;
				LOGGER.warn("DMEventEngine[Config.load()]: invalid config property -> DMEventParticipationNpcCoordinates");
			}
			else
			{
				if (DM_EVENT_ENABLED)
				{
					DM_EVENT_REWARDS = new HashMap<>();
					DM_DOORS_IDS_TO_OPEN = new ArrayList<>();
					DM_DOORS_IDS_TO_CLOSE = new ArrayList<>();
					DM_EVENT_PLAYER_COORDINATES = new ArrayList<>();
					
					DM_EVENT_PARTICIPATION_NPC_COORDINATES = new int[4];
					DM_EVENT_PARTICIPATION_NPC_COORDINATES[0] = Integer.parseInt(propertySplit[0]);
					DM_EVENT_PARTICIPATION_NPC_COORDINATES[1] = Integer.parseInt(propertySplit[1]);
					DM_EVENT_PARTICIPATION_NPC_COORDINATES[2] = Integer.parseInt(propertySplit[2]);
					
					if (propertySplit.length == 4)
						DM_EVENT_PARTICIPATION_NPC_COORDINATES[3] = Integer.parseInt(propertySplit[3]);
					DM_EVENT_MIN_PLAYERS = events.getProperty("DMEventMinPlayers", 1);
					DM_EVENT_MAX_PLAYERS = events.getProperty("DMEventMaxPlayers", 20);
					DM_EVENT_MIN_LVL = (byte) events.getProperty("DMEventMinPlayerLevel", 1);
					DM_EVENT_MAX_LVL = (byte) events.getProperty("DMEventMaxPlayerLevel", 80);
					DM_EVENT_RESPAWN_TELEPORT_DELAY = events.getProperty("DMEventRespawnTeleportDelay", 20);
					DM_EVENT_START_LEAVE_TELEPORT_DELAY = events.getProperty("DMEventStartLeaveTeleportDelay", 20);
					DM_EVENT_EFFECTS_REMOVAL = events.getProperty("DMEventEffectsRemoval", 0);
					
					propertySplit = events.getProperty("DMEventParticipationFee", "0,0").split(",");
					try
					{
						DM_EVENT_PARTICIPATION_FEE[0] = Integer.parseInt(propertySplit[0]);
						DM_EVENT_PARTICIPATION_FEE[1] = Integer.parseInt(propertySplit[1]);
					}
					catch (NumberFormatException nfe)
					{
						if (propertySplit.length > 0)
							LOGGER.warn("DMEventEngine[Config.load()]: invalid config property -> DMEventParticipationFee");
					}
					
					DM_REWARD_FIRST_PLAYERS = events.getProperty("DMRewardFirstPlayers", 3);
					
					propertySplit = events.getProperty("DMEventReward", "57,100000;5575,5000|57,50000|57,25000").split("\\|");
					int i = 1;
					if (DM_REWARD_FIRST_PLAYERS < propertySplit.length)
						LOGGER.warn("DMEventEngine[Config.load()]: invalid config property -> DMRewardFirstPlayers < DMEventReward");
					else
					{
						for (String pos : propertySplit)
						{
							List<int[]> value = new ArrayList<>();
							String[] rewardSplit = pos.split("\\;");
							for (String rewards : rewardSplit)
							{
								String[] reward = rewards.split("\\,");
								if (reward.length != 2)
									LOGGER.warn("DMEventEngine[Config.load()]: invalid config property -> DMEventReward \"" + pos + "\"");
								else
								{
									try
									{
										value.add(new int[]
										{
											Integer.parseInt(reward[0]),
											Integer.parseInt(reward[1])
										});
									}
									catch (NumberFormatException nfe)
									{
										LOGGER.warn("DMEventEngine[Config.load()]: invalid config property -> DMEventReward \"" + pos + "\"");
									}
								}
								
								try
								{
									if (value.isEmpty())
										DM_EVENT_REWARDS.put(i, DM_EVENT_REWARDS.get(i - 1));
									else
										DM_EVENT_REWARDS.put(i, value);
								}
								catch (Exception e)
								{
									LOGGER.warn("DMEventEngine[Config.load()]: invalid config property -> DMEventReward array index out of bounds (1)");
									e.printStackTrace();
								}
								i++;
							}
						}
						
						int countPosRewards = DM_EVENT_REWARDS.size();
						if (countPosRewards < DM_REWARD_FIRST_PLAYERS)
						{
							for (i = countPosRewards + 1; i <= DM_REWARD_FIRST_PLAYERS; i++)
							{
								try
								{
									DM_EVENT_REWARDS.put(i, DM_EVENT_REWARDS.get(i - 1));
								}
								catch (Exception e)
								{
									LOGGER.warn("DMEventEngine[Config.load()]: invalid config property -> DMEventReward array index out of bounds (2)");
									e.printStackTrace();
								}
							}
						}
					}
					
					propertySplit = events.getProperty("DMEventPlayerCoordinates", "0,0,0").split(";");
					for (String coordPlayer : propertySplit)
					{
						String[] coordSplit = coordPlayer.split(",");
						if (coordSplit.length != 3)
							LOGGER.warn("DMEventEngine[Config.load()]: invalid config property -> DMEventPlayerCoordinates \"" + coordPlayer + "\"");
						else
						{
							try
							{
								DM_EVENT_PLAYER_COORDINATES.add(new int[]
								{
									Integer.parseInt(coordSplit[0]),
									Integer.parseInt(coordSplit[1]),
									Integer.parseInt(coordSplit[2])
								});
							}
							catch (NumberFormatException nfe)
							{
								if (!coordPlayer.isEmpty())
									LOGGER.warn("DMEventEngine[Config.load()]: invalid config property -> DMEventPlayerCoordinates \"" + coordPlayer + "\"");
							}
						}
					}
					
					DM_EVENT_SCROLL_ALLOWED = events.getProperty("DMEventScrollsAllowed", false);
					DM_EVENT_POTIONS_ALLOWED = events.getProperty("DMEventPotionsAllowed", false);
					DM_EVENT_SUMMON_BY_ITEM_ALLOWED = events.getProperty("DMEventSummonByItemAllowed", false);
					DM_REWARD_PLAYERS_TIE = events.getProperty("DMRewardPlayersTie", false);
					
					DISABLE_ID_CLASSES_STRING = events.getProperty("DMDisabledForClasses");
					DISABLE_ID_CLASSES = new ArrayList<>();
					for (String class_id : DISABLE_ID_CLASSES_STRING.split(","))
						DISABLE_ID_CLASSES.add(Integer.parseInt(class_id));
					
					propertySplit = events.getProperty("DMDoorsToOpen", "").split(";");
					for (String door : propertySplit)
					{
						try
						{
							DM_DOORS_IDS_TO_OPEN.add(Integer.parseInt(door));
						}
						catch (NumberFormatException nfe)
						{
							if (!door.isEmpty())
								LOGGER.warn("DMEventEngine[Config.load()]: invalid config property -> DMDoorsToOpen \"" + door + "\"");
						}
					}
					
					propertySplit = events.getProperty("DMDoorsToClose", "").split(";");
					for (String door : propertySplit)
					{
						try
						{
							DM_DOORS_IDS_TO_CLOSE.add(Integer.parseInt(door));
						}
						catch (NumberFormatException nfe)
						{
							if (!door.isEmpty())
								LOGGER.warn("DMEventEngine[Config.load()]: invalid config property -> DMDoorsToClose \"" + door + "\"");
						}
					}
					
					propertySplit = events.getProperty("DMEventFighterBuffs", "").split(";");
					if (!propertySplit[0].isEmpty())
					{
						DM_EVENT_FIGHTER_BUFFS = new HashMap<>(propertySplit.length);
						for (String skill : propertySplit)
						{
							String[] skillSplit = skill.split(",");
							if (skillSplit.length != 2)
								LOGGER.warn("DMEventEngine[Config.load()]: invalid config property -> DMEventFighterBuffs \"" + skill + "\"");
							else
							{
								try
								{
									DM_EVENT_FIGHTER_BUFFS.put(Integer.parseInt(skillSplit[0]), Integer.parseInt(skillSplit[1]));
								}
								catch (NumberFormatException nfe)
								{
									if (!skill.isEmpty())
										LOGGER.warn("DMEventEngine[Config.load()]: invalid config property -> DMEventFighterBuffs \"" + skill + "\"");
								}
							}
						}
					}
					
					propertySplit = events.getProperty("DMEventMageBuffs", "").split(";");
					if (!propertySplit[0].isEmpty())
					{
						DM_EVENT_MAGE_BUFFS = new HashMap<>(propertySplit.length);
						for (String skill : propertySplit)
						{
							String[] skillSplit = skill.split(",");
							if (skillSplit.length != 2)
								LOGGER.warn("DMEventEngine[Config.load()]: invalid config property -> DMEventMageBuffs \"" + skill + "\"");
							else
							{
								try
								{
									DM_EVENT_MAGE_BUFFS.put(Integer.parseInt(skillSplit[0]), Integer.parseInt(skillSplit[1]));
								}
								catch (NumberFormatException nfe)
								{
									if (!skill.isEmpty())
										LOGGER.warn("DMEventEngine[Config.load()]: invalid config property -> DMEventMageBuffs \"" + skill + "\"");
								}
							}
						}
					}
				}
			}
			LM_EVENT_ENABLED = events.getProperty("LMEventEnabled", false);
			LM_EVENT_INTERVAL = events.getProperty("LMEventInterval", "8:00,14:00,20:00,2:00").split(",");
			String[] timeParticipation2 = events.getProperty("LMEventParticipationTime", "01:00:00").split(":");
			Long timeLM = 0L;
			timeLM += Long.parseLong(timeParticipation2[0]) * 3600L;
			timeLM += Long.parseLong(timeParticipation2[1]) * 60L;
			timeLM += Long.parseLong(timeParticipation2[2]);
			LM_EVENT_PARTICIPATION_TIME = timeLM * 1000L;
			LM_EVENT_RUNNING_TIME = events.getProperty("LMEventRunningTime", 1800);
			LM_NPC_LOC_NAME = events.getProperty("LMNpcLocName", "Giran Town");
			LM_EVENT_PARTICIPATION_NPC_ID = events.getProperty("LMEventParticipationNpcId", 0);
			short credits = Short.parseShort(events.getProperty("LMEventPlayerCredits", "1"));
			LM_EVENT_PLAYER_CREDITS = (credits > 0 ? credits : 1);
			if (LM_EVENT_PARTICIPATION_NPC_ID == 0)
			{
				LM_EVENT_ENABLED = false;
				LOGGER.warn("LMEventEngine[Config.load()]: invalid config property -> LMEventParticipationNpcId");
			}
			else
			{
				String[] propertySplitLM = events.getProperty("LMEventParticipationNpcCoordinates", "0,0,0").split(",");
				if (propertySplitLM.length < 3)
				{
					LM_EVENT_ENABLED = false;
					LOGGER.warn("LMEventEngine[Config.load()]: invalid config property -> LMEventParticipationNpcCoordinates");
				}
				else
				{
					if (LM_EVENT_ENABLED)
					{
						LM_EVENT_REWARDS = new ArrayList<>();
						LM_DOORS_IDS_TO_OPEN = new ArrayList<>();
						LM_DOORS_IDS_TO_CLOSE = new ArrayList<>();
						LM_EVENT_PLAYER_COORDINATES = new ArrayList<>();
						
						LM_EVENT_PARTICIPATION_NPC_COORDINATES = new int[4];
						LM_EVENT_PARTICIPATION_NPC_COORDINATES[0] = Integer.parseInt(propertySplitLM[0]);
						LM_EVENT_PARTICIPATION_NPC_COORDINATES[1] = Integer.parseInt(propertySplitLM[1]);
						LM_EVENT_PARTICIPATION_NPC_COORDINATES[2] = Integer.parseInt(propertySplitLM[2]);
						
						if (propertySplitLM.length == 4)
							LM_EVENT_PARTICIPATION_NPC_COORDINATES[3] = Integer.parseInt(propertySplitLM[3]);
						LM_EVENT_MIN_PLAYERS = events.getProperty("LMEventMinPlayers", 1);
						LM_EVENT_MAX_PLAYERS = events.getProperty("LMEventMaxPlayers", 20);
						LM_EVENT_MIN_LVL = (byte) events.getProperty("LMEventMinPlayerLevel", 1);
						LM_EVENT_MAX_LVL = (byte) events.getProperty("LMEventMaxPlayerLevel", 80);
						LM_EVENT_RESPAWN_TELEPORT_DELAY = events.getProperty("LMEventRespawnTeleportDelay", 20);
						LM_EVENT_START_LEAVE_TELEPORT_DELAY = events.getProperty("LMEventStartLeaveTeleportDelay", 20);
						LM_EVENT_EFFECTS_REMOVAL = events.getProperty("LMEventEffectsRemoval", 0);
						
						propertySplitLM = events.getProperty("LMEventParticipationFee", "0,0").split(",");
						try
						{
							LM_EVENT_PARTICIPATION_FEE[0] = Integer.parseInt(propertySplitLM[0]);
							LM_EVENT_PARTICIPATION_FEE[1] = Integer.parseInt(propertySplitLM[1]);
						}
						catch (NumberFormatException nfe)
						{
							if (propertySplitLM.length > 0)
								LOGGER.warn("LMEventEngine[Config.load()]: invalid config property -> LMEventParticipationFee");
						}
						
						propertySplitLM = events.getProperty("LMEventReward", "57,100000;5575,5000").split("\\;");
						for (String reward : propertySplitLM)
						{
							String[] rewardSplit2 = reward.split("\\,");
							try
							{
								LM_EVENT_REWARDS.add(new int[]
								{
									Integer.parseInt(rewardSplit2[0]),
									Integer.parseInt(rewardSplit2[1])
								});
							}
							catch (NumberFormatException nfe)
							{
								LOGGER.warn("LMEventEngine[Config.load()]: invalid config property -> LM_EVENT_REWARDS");
							}
						}
						
						propertySplitLM = events.getProperty("LMEventPlayerCoordinates", "0,0,0").split(";");
						for (String coordPlayer : propertySplitLM)
						{
							String[] coordSplit = coordPlayer.split(",");
							if (coordSplit.length != 3)
								LOGGER.warn("LMEventEngine[Config.load()]: invalid config property -> LMEventPlayerCoordinates \"" + coordPlayer + "\"");
							else
							{
								try
								{
									LM_EVENT_PLAYER_COORDINATES.add(new int[]
									{
										Integer.parseInt(coordSplit[0]),
										Integer.parseInt(coordSplit[1]),
										Integer.parseInt(coordSplit[2])
									});
								}
								catch (NumberFormatException nfe)
								{
									if (!coordPlayer.isEmpty())
										LOGGER.warn("LMEventEngine[Config.load()]: invalid config property -> LMEventPlayerCoordinates \"" + coordPlayer + "\"");
								}
							}
						}
						
						LM_EVENT_SCROLL_ALLOWED = events.getProperty("LMEventScrollsAllowed", false);
						LM_EVENT_POTIONS_ALLOWED = events.getProperty("LMEventPotionsAllowed", false);
						LM_EVENT_SUMMON_BY_ITEM_ALLOWED = events.getProperty("LMEventSummonByItemAllowed", false);
						LM_REWARD_PLAYERS_TIE = events.getProperty("LMRewardPlayersTie", false);
						
						DISABLE_ID_CLASSES_STRING = events.getProperty("LMDisabledForClasses");
						DISABLE_ID_CLASSES = new ArrayList<>();
						for (String class_id : DISABLE_ID_CLASSES_STRING.split(","))
							DISABLE_ID_CLASSES.add(Integer.parseInt(class_id));
						
						propertySplitLM = events.getProperty("LMDoorsToOpen", "").split(";");
						for (String door : propertySplitLM)
						{
							try
							{
								LM_DOORS_IDS_TO_OPEN.add(Integer.parseInt(door));
							}
							catch (NumberFormatException nfe)
							{
								if (!door.isEmpty())
									LOGGER.warn("LMEventEngine[Config.load()]: invalid config property -> LMDoorsToOpen \"" + door + "\"");
							}
						}
						
						propertySplitLM = events.getProperty("LMDoorsToClose", "").split(";");
						for (String door : propertySplitLM)
						{
							try
							{
								LM_DOORS_IDS_TO_CLOSE.add(Integer.parseInt(door));
							}
							catch (NumberFormatException nfe)
							{
								if (!door.isEmpty())
									LOGGER.warn("LMEventEngine[Config.load()]: invalid config property -> LMDoorsToClose \"" + door + "\"");
							}
						}
						
						propertySplitLM = events.getProperty("LMEventFighterBuffs", "").split(";");
						if (!propertySplitLM[0].isEmpty())
						{
							LM_EVENT_FIGHTER_BUFFS = new HashMap<>(propertySplitLM.length);
							for (String skill : propertySplitLM)
							{
								String[] skillSplit = skill.split(",");
								if (skillSplit.length != 2)
									LOGGER.warn("LMEventEngine[Config.load()]: invalid config property -> LMEventFighterBuffs \"" + skill + "\"");
								else
								{
									try
									{
										LM_EVENT_FIGHTER_BUFFS.put(Integer.parseInt(skillSplit[0]), Integer.parseInt(skillSplit[1]));
									}
									catch (NumberFormatException nfe)
									{
										if (!skill.isEmpty())
											LOGGER.warn("LMEventEngine[Config.load()]: invalid config property -> LMEventFighterBuffs \"" + skill + "\"");
									}
								}
							}
						}
						
						propertySplitLM = events.getProperty("LMEventMageBuffs", "").split(";");
						if (!propertySplitLM[0].isEmpty())
						{
							LM_EVENT_MAGE_BUFFS = new HashMap<>(propertySplitLM.length);
							for (String skill : propertySplitLM)
							{
								String[] skillSplit = skill.split(",");
								if (skillSplit.length != 2)
									LOGGER.warn("LMEventEngine[Config.load()]: invalid config property -> LMEventMageBuffs \"" + skill + "\"");
								else
								{
									try
									{
										LM_EVENT_MAGE_BUFFS.put(Integer.parseInt(skillSplit[0]), Integer.parseInt(skillSplit[1]));
									}
									catch (NumberFormatException nfe)
									{
										if (!skill.isEmpty())
											LOGGER.warn("LMEventEngine[Config.load()]: invalid config property -> LMEventMageBuffs \"" + skill + "\"");
									}
								}
							}
						}
					}
				}
				
				TVT_EVENT_ENABLED = events.getProperty("TvTEventEnabled", false);
				TVT_EVENT_INTERVAL = events.getProperty("TvTEventInterval", "20:00").split(",");
				TVT_EVENT_PARTICIPATION_TIME = events.getProperty("TvTEventParticipationTime", 3600);
				TVT_EVENT_RUNNING_TIME = events.getProperty("TvTEventRunningTime", 1800);
				TVT_NPC_LOC_NAME = events.getProperty("TvTNpcLocName", "Giran Town");
				TVT_EVENT_PARTICIPATION_NPC_ID = events.getProperty("TvTEventParticipationNpcId", 0);
				
				if (TVT_EVENT_PARTICIPATION_NPC_ID == 0)
				{
					TVT_EVENT_ENABLED = false;
					LOGGER.warn("TvTEventEngine: invalid config property -> TvTEventParticipationNpcId");
				}
				else
				{
					String[] propertySplitTvT = events.getProperty("TvTEventParticipationNpcCoordinates", "0,0,0").split(",");
					if (propertySplitTvT.length < 3)
					{
						TVT_EVENT_ENABLED = false;
						LOGGER.warn("TvTEventEngine: invalid config property -> TvTEventParticipationNpcCoordinates");
					}
					else
					{
						TVT_EVENT_REWARDS = new ArrayList<>();
						TVT_DOORS_IDS_TO_OPEN = new ArrayList<>();
						TVT_DOORS_IDS_TO_CLOSE = new ArrayList<>();
						TVT_EVENT_PARTICIPATION_NPC_COORDINATES = new int[4];
						TVT_EVENT_TEAM_1_COORDINATES = new int[3];
						TVT_EVENT_TEAM_2_COORDINATES = new int[3];
						TVT_EVENT_PARTICIPATION_NPC_COORDINATES[0] = Integer.parseInt(propertySplitTvT[0]);
						TVT_EVENT_PARTICIPATION_NPC_COORDINATES[1] = Integer.parseInt(propertySplitTvT[1]);
						TVT_EVENT_PARTICIPATION_NPC_COORDINATES[2] = Integer.parseInt(propertySplitTvT[2]);
						if (propertySplitTvT.length == 4)
						{
							TVT_EVENT_PARTICIPATION_NPC_COORDINATES[3] = Integer.parseInt(propertySplitTvT[3]);
						}
						TVT_EVENT_MIN_PLAYERS_IN_TEAMS = events.getProperty("TvTEventMinPlayersInTeams", 1);
						TVT_EVENT_MAX_PLAYERS_IN_TEAMS = events.getProperty("TvTEventMaxPlayersInTeams", 20);
						TVT_EVENT_MIN_LVL = Byte.parseByte(events.getProperty("TvTEventMinPlayerLevel", "1"));
						TVT_EVENT_MAX_LVL = Byte.parseByte(events.getProperty("TvTEventMaxPlayerLevel", "80"));
						TVT_EVENT_RESPAWN_TELEPORT_DELAY = events.getProperty("TvTEventRespawnTeleportDelay", 20);
						TVT_EVENT_START_LEAVE_TELEPORT_DELAY = events.getProperty("TvTEventStartLeaveTeleportDelay", 20);
						TVT_EVENT_EFFECTS_REMOVAL = events.getProperty("TvTEventEffectsRemoval", 0);
						TVT_EVENT_TEAM_1_NAME = events.getProperty("TvTEventTeam1Name", "Team1");
						propertySplitTvT = events.getProperty("TvTEventTeam1Coordinates", "0,0,0").split(",");
						if (propertySplitTvT.length < 3)
						{
							TVT_EVENT_ENABLED = false;
							LOGGER.warn("TvTEventEngine: invalid config property -> TvTEventTeam1Coordinates");
						}
						else
						{
							TVT_EVENT_TEAM_1_COORDINATES[0] = Integer.parseInt(propertySplitTvT[0]);
							TVT_EVENT_TEAM_1_COORDINATES[1] = Integer.parseInt(propertySplitTvT[1]);
							TVT_EVENT_TEAM_1_COORDINATES[2] = Integer.parseInt(propertySplitTvT[2]);
							TVT_EVENT_TEAM_2_NAME = events.getProperty("TvTEventTeam2Name", "Team2");
							propertySplitTvT = events.getProperty("TvTEventTeam2Coordinates", "0,0,0").split(",");
							if (propertySplitTvT.length < 3)
							{
								TVT_EVENT_ENABLED = false;
								LOGGER.warn("TvTEventEngine: invalid config property -> TvTEventTeam2Coordinates");
							}
							else
							{
								TVT_EVENT_TEAM_2_COORDINATES[0] = Integer.parseInt(propertySplitTvT[0]);
								TVT_EVENT_TEAM_2_COORDINATES[1] = Integer.parseInt(propertySplitTvT[1]);
								TVT_EVENT_TEAM_2_COORDINATES[2] = Integer.parseInt(propertySplitTvT[2]);
								propertySplitTvT = events.getProperty("TvTEventParticipationFee", "0,0").split(",");
								
								try
								{
									TVT_EVENT_PARTICIPATION_FEE[0] = Integer.parseInt(propertySplitTvT[0]);
									TVT_EVENT_PARTICIPATION_FEE[1] = Integer.parseInt(propertySplitTvT[1]);
								}
								catch (NumberFormatException nfe)
								{
									if (propertySplitTvT.length > 0)
									{
										LOGGER.warn("TvTEventEngine: invalid config property -> TvTEventParticipationFee");
									}
								}
								
								propertySplitTvT = events.getProperty("TvTEventReward", "57,100000").split(";");
								for (String reward : propertySplitTvT)
								{
									String[] rewardSplit = reward.split(",");
									if (rewardSplit.length != 2)
										LOGGER.warn("TvTEventEngine: invalid config property -> TvTEventReward \"" + reward + "\"");
									else
									{
										try
										{
											TVT_EVENT_REWARDS.add(new int[]
											{
												Integer.parseInt(rewardSplit[0]),
												Integer.parseInt(rewardSplit[1])
											});
										}
										catch (NumberFormatException nfe)
										{
											if (!reward.isEmpty())
												LOGGER.warn("TvTEventEngine: invalid config property -> TvTEventReward \"" + reward + "\"");
										}
									}
								}
								
								TVT_EVENT_TARGET_TEAM_MEMBERS_ALLOWED = events.getProperty("TvTEventTargetTeamMembersAllowed", true);
								TVT_EVENT_SCROLL_ALLOWED = events.getProperty("TvTEventScrollsAllowed", false);
								TVT_EVENT_POTIONS_ALLOWED = events.getProperty("TvTEventPotionsAllowed", false);
								TVT_EVENT_SUMMON_BY_ITEM_ALLOWED = events.getProperty("TvTEventSummonByItemAllowed", false);
								TVT_REWARD_TEAM_TIE = events.getProperty("TvTRewardTeamTie", false);
								propertySplitTvT = events.getProperty("TvTDoorsToOpen", "").split(";");
								for (String door : propertySplitTvT)
								{
									try
									{
										TVT_DOORS_IDS_TO_OPEN.add(Integer.parseInt(door));
									}
									catch (NumberFormatException nfe)
									{
										if (!door.isEmpty())
											LOGGER.warn("TvTEventEngine: invalid config property -> TvTDoorsToOpen \"" + door + "\"");
									}
								}
								
								propertySplitTvT = events.getProperty("TvTDoorsToClose", "").split(";");
								for (String door : propertySplitTvT)
								{
									try
									{
										TVT_DOORS_IDS_TO_CLOSE.add(Integer.parseInt(door));
									}
									catch (NumberFormatException nfe)
									{
										if (!door.isEmpty())
											LOGGER.warn("TvTEventEngine: invalid config property -> TvTDoorsToClose \"" + door + "\"");
									}
								}
								
								propertySplitTvT = events.getProperty("TvTEventFighterBuffs", "").split(";");
								if (!propertySplitTvT[0].isEmpty())
								{
									TVT_EVENT_FIGHTER_BUFFS = new HashMap<>(propertySplitTvT.length);
									for (String skill : propertySplitTvT)
									{
										String[] skillSplit = skill.split(",");
										if (skillSplit.length != 2)
											LOGGER.warn("TvTEventEngine: invalid config property -> TvTEventFighterBuffs \"" + skill + "\"");
										else
										{
											try
											{
												TVT_EVENT_FIGHTER_BUFFS.put(Integer.parseInt(skillSplit[0]), Integer.parseInt(skillSplit[1]));
											}
											catch (NumberFormatException nfe)
											{
												if (!skill.isEmpty())
													LOGGER.warn("TvTEventEngine: invalid config property -> TvTEventFighterBuffs \"" + skill + "\"");
											}
										}
									}
								}
								
								propertySplitTvT = events.getProperty("TvTEventMageBuffs", "").split(";");
								if (!propertySplitTvT[0].isEmpty())
								{
									TVT_EVENT_MAGE_BUFFS = new HashMap<>(propertySplitTvT.length);
									for (String skill : propertySplitTvT)
									{
										String[] skillSplit = skill.split(",");
										if (skillSplit.length != 2)
											LOGGER.warn("TvTEventEngine: invalid config property -> TvTEventMageBuffs \"" + skill + "\"");
										else
										{
											try
											{
												TVT_EVENT_MAGE_BUFFS.put(Integer.parseInt(skillSplit[0]), Integer.parseInt(skillSplit[1]));
											}
											catch (NumberFormatException nfe)
											{
												if (!skill.isEmpty())
													LOGGER.warn("TvTEventEngine: invalid config property -> TvTEventMageBuffs \"" + skill + "\"");
											}
										}
									}
								}
								
								TVT_REWARD_PLAYER = events.getProperty("TvTRewardOnlyKillers", false);
								
								TVT_EVENT_ON_KILL = events.getProperty("TvTEventOnKill", "pmteam");
								DISABLE_ID_CLASSES_STRING_TVT = events.getProperty("TvTDisabledForClasses");
								DISABLE_ID_CLASSES_TVT = new ArrayList<>();
								for (String class_id : DISABLE_ID_CLASSES_STRING_TVT.split(","))
									DISABLE_ID_CLASSES_TVT.add(Integer.parseInt(class_id));
								
								ALLOW_TVT_DLG = events.getProperty("AllowDlgTvTInvite", false);
								TVT_EVENT_MAX_PARTICIPANTS_PER_IP = events.getProperty("TvTEventMaxParticipantsPerIP", 0);
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * Loads geoengine settings.
	 */
	private static final void loadGeoengine()
	{
		final ExProperties geoengine = initProperties(GEOENGINE_FILE);
		
		GEODATA_PATH = geoengine.getProperty("GeoDataPath", "./data/geodata/");
		GEODATA_TYPE = Enum.valueOf(GeoType.class, geoengine.getProperty("GeoDataType", "L2OFF"));
		
		PART_OF_CHARACTER_HEIGHT = geoengine.getProperty("PartOfCharacterHeight", 75);
		MAX_OBSTACLE_HEIGHT = geoengine.getProperty("MaxObstacleHeight", 32);
		
		PATHFIND_BUFFERS = geoengine.getProperty("PathFindBuffers", "500x10;1000x10;3000x5;5000x3;10000x3");
		MOVE_WEIGHT = geoengine.getProperty("MoveWeight", 10);
		MOVE_WEIGHT_DIAG = geoengine.getProperty("MoveWeightDiag", 14);
		OBSTACLE_WEIGHT = geoengine.getProperty("ObstacleWeight", 30);
		OBSTACLE_WEIGHT_DIAG = (int) (OBSTACLE_WEIGHT * Math.sqrt(2));
		HEURISTIC_WEIGHT = geoengine.getProperty("HeuristicWeight", 12);
		HEURISTIC_WEIGHT_DIAG = geoengine.getProperty("HeuristicWeightDiag", 18);
		MAX_ITERATIONS = geoengine.getProperty("MaxIterations", 3500);
	}
	
	/**
	 * Loads hex ID settings.
	 */
	private static final void loadHexID()
	{
		final ExProperties hexid = initProperties(HEXID_FILE);
		
		SERVER_ID = Integer.parseInt(hexid.getProperty("ServerID"));
		HEX_ID = new BigInteger(hexid.getProperty("HexID"), 16).toByteArray();
	}
	
	/**
	 * Saves hex ID file.
	 * @param serverId : The ID of server.
	 * @param hexId : The hex ID of server.
	 */
	public static final void saveHexid(int serverId, String hexId)
	{
		saveHexid(serverId, hexId, HEXID_FILE);
	}
	
	/**
	 * Saves hexID file.
	 * @param serverId : The ID of server.
	 * @param hexId : The hexID of server.
	 * @param filename : The file name.
	 */
	public static final void saveHexid(int serverId, String hexId, String filename)
	{
		try
		{
			final File file = new File(filename);
			file.createNewFile();
			
			final Properties hexSetting = new Properties();
			hexSetting.setProperty("ServerID", String.valueOf(serverId));
			hexSetting.setProperty("HexID", hexId);
			
			try (OutputStream out = new FileOutputStream(file))
			{
				hexSetting.store(out, "the hexID to auth into login");
			}
		}
		catch (Exception e)
		{
			LOGGER.error("Failed to save hex ID to '{}' file.", e, filename);
		}
	}
	
	/**
	 * Loads NPC settings.<br>
	 * Such as champion monsters, NPC buffer, class master, wyvern, raid bosses and grand bosses, AI.
	 */
	private static final void loadNpcs()
	{
		final ExProperties npcs = initProperties(NPCS_FILE);
		
		SPAWN_MULTIPLIER = npcs.getProperty("SpawnMultiplier", 1.);
		SPAWN_EVENTS = npcs.getProperty("SpawnEvents", new String[]
		{
			"extra_mob",
			"18age",
			"start_weapon",
		});
		
		CHAMPION_FREQUENCY = npcs.getProperty("ChampionFrequency", 0);
		CHAMPION_DEEPBLUE_DROP_RULES = npcs.getProperty("UseChampionDeepBlueDropRules", false);
		CHAMP_MIN_LVL = npcs.getProperty("ChampionMinLevel", 20);
		CHAMP_MAX_LVL = npcs.getProperty("ChampionMaxLevel", 70);
		CHAMPION_HP = npcs.getProperty("ChampionHp", 8);
		CHAMPION_HP_REGEN = npcs.getProperty("ChampionHpRegen", 1.);
		CHAMPION_RATE_XP = npcs.getProperty("ChampionRateXp", 1.);
		CHAMPION_RATE_SP = npcs.getProperty("ChampionRateSp", 1.);
		PREMIUM_CHAMPION_RATE_XP = npcs.getProperty("PremiumChampionRateXp", 1.);
		PREMIUM_CHAMPION_RATE_SP = npcs.getProperty("PremiumChampionRateSp", 1.);
		CHAMPION_REWARDS = npcs.getProperty("ChampionRewards", 1);
		PREMIUM_CHAMPION_REWARDS = npcs.getProperty("PremiumChampionRewards", 1);
		CHAMPION_ADENAS_REWARDS = npcs.getProperty("ChampionAdenasRewards", 1);
		PREMIUM_CHAMPION_ADENAS_REWARDS = npcs.getProperty("PremiumChampionAdenasRewards", 1);
		CHAMPION_ATK = npcs.getProperty("ChampionAtk", 1.);
		CHAMPION_SPD_ATK = npcs.getProperty("ChampionSpdAtk", 1.);
		CHAMPION_REWARD = npcs.getProperty("ChampionRewardItem", 0);
		CHAMPION_REWARD_ID = npcs.getProperty("ChampionRewardItemID", 6393);
		CHAMPION_REWARD_QTY = npcs.getProperty("ChampionRewardItemQty", 1);
		CHAMPION_AURA = npcs.getProperty("ChampionAura", 0);
		
		ALLOW_ENTIRE_TREE = npcs.getProperty("AllowEntireTree", false);
		CLASS_MASTER_SETTINGS = new ClassMasterSettings(npcs.getProperty("ConfigClassMaster"));
		
		WEDDING_PRICE = npcs.getProperty("WeddingPrice", 1000000);
		WEDDING_SAMESEX = npcs.getProperty("WeddingAllowSameSex", false);
		WEDDING_FORMALWEAR = npcs.getProperty("WeddingFormalWear", true);
		
		BUFFER_MAX_SCHEMES = npcs.getProperty("BufferMaxSchemesPerChar", 4);
		BUFFER_STATIC_BUFF_COST = npcs.getProperty("BufferStaticCostPerBuff", -1);
		
		WYVERN_REQUIRED_LEVEL = npcs.getProperty("RequiredStriderLevel", 55);
		WYVERN_REQUIRED_CRYSTALS = npcs.getProperty("RequiredCrystalsNumber", 10);
		
		FREE_TELEPORT = npcs.getProperty("FreeTeleport", false);
		LVL_FREE_TELEPORT = npcs.getProperty("LvlFreeTeleport", 40);
		ANNOUNCE_MAMMON_SPAWN = npcs.getProperty("AnnounceMammonSpawn", true);
		MOB_AGGRO_IN_PEACEZONE = npcs.getProperty("MobAggroInPeaceZone", true);
		SHOW_NPC_LVL = npcs.getProperty("ShowNpcLevel", false);
		SHOW_NPC_CREST = npcs.getProperty("ShowNpcCrest", false);
		SHOW_SUMMON_CREST = npcs.getProperty("ShowSummonCrest", false);
		
		RAID_HP_REGEN_MULTIPLIER = npcs.getProperty("RaidHpRegenMultiplier", 1.);
		RAID_MP_REGEN_MULTIPLIER = npcs.getProperty("RaidMpRegenMultiplier", 1.);
		RAID_DEFENCE_MULTIPLIER = npcs.getProperty("RaidDefenceMultiplier", 1.);
		RAID_MINION_RESPAWN_TIMER = npcs.getProperty("RaidMinionRespawnTime", 300000);
		
		RAID_DISABLE_CURSE = npcs.getProperty("DisableRaidCurse", false);
		
		SPAWN_INTERVAL_ANTHARAS = npcs.getProperty("AntharasSpawnInterval", 264);
		RANDOM_SPAWN_TIME_ANTHARAS = npcs.getProperty("AntharasRandomSpawn", 72);
		WAIT_TIME_ANTHARAS = npcs.getProperty("AntharasWaitTime", 30) * 60000;
		
		SPAWN_INTERVAL_BAIUM = npcs.getProperty("BaiumSpawnInterval", 168);
		RANDOM_SPAWN_TIME_BAIUM = npcs.getProperty("BaiumRandomSpawn", 48);
		
		SPAWN_INTERVAL_FRINTEZZA = npcs.getProperty("FrintezzaSpawnInterval", 48);
		RANDOM_SPAWN_TIME_FRINTEZZA = npcs.getProperty("FrintezzaRandomSpawn", 8);
		WAIT_TIME_FRINTEZZA = npcs.getProperty("FrintezzaWaitTime", 1) * 60000;
		
		SPAWN_INTERVAL_SAILREN = npcs.getProperty("SailrenSpawnInterval", 36);
		RANDOM_SPAWN_TIME_SAILREN = npcs.getProperty("SailrenRandomSpawn", 24);
		WAIT_TIME_SAILREN = npcs.getProperty("SailrenWaitTime", 5) * 60000;
		
		SPAWN_INTERVAL_VALAKAS = npcs.getProperty("ValakasSpawnInterval", 264);
		RANDOM_SPAWN_TIME_VALAKAS = npcs.getProperty("ValakasRandomSpawn", 72);
		WAIT_TIME_VALAKAS = npcs.getProperty("ValakasWaitTime", 30) * 60000;
		
		SPAWN_INTERVAL_DR_CHAOS = npcs.getProperty("DrChaosSpawnInterval", 36);
		RANDOM_SPAWN_TIME_DR_CHAOS = npcs.getProperty("DrChaosRandomSpawn", 24);
		
		SPAWN_INTERVAL_HALTER = npcs.getProperty("HalterSpawnInterval", 36);
		RANDOM_SPAWN_TIME_HALTER = npcs.getProperty("HalterRandomSpawn", 24);
		
		GUARD_ATTACK_AGGRO_MOB = npcs.getProperty("GuardAttackAggroMob", false);
		RANDOM_WALK_RATE = npcs.getProperty("RandomWalkRate", 30);
		MAX_DRIFT_RANGE = npcs.getProperty("MaxDriftRange", 200);
		MIN_NPC_ANIMATION = npcs.getProperty("MinNPCAnimation", 20);
		MAX_NPC_ANIMATION = npcs.getProperty("MaxNPCAnimation", 40);
		MIN_MONSTER_ANIMATION = npcs.getProperty("MinMonsterAnimation", 10);
		MAX_MONSTER_ANIMATION = npcs.getProperty("MaxMonsterAnimation", 40);
	}
	
	/**
	 * Loads player settings.<br>
	 * Such as stats, inventory/warehouse, enchant, augmentation, karma, party, admin, petition, skill learn.
	 */
	private static final void loadPlayers()
	{
		final ExProperties players = initProperties(PLAYERS_FILE);
		
		EFFECT_CANCELING = players.getProperty("CancelLesserEffect", true);
		HP_REGEN_MULTIPLIER = players.getProperty("HpRegenMultiplier", 1.);
		MP_REGEN_MULTIPLIER = players.getProperty("MpRegenMultiplier", 1.);
		CP_REGEN_MULTIPLIER = players.getProperty("CpRegenMultiplier", 1.);
		PLAYER_SPAWN_PROTECTION = players.getProperty("PlayerSpawnProtection", 0);
		PLAYER_FAKEDEATH_UP_PROTECTION = players.getProperty("PlayerFakeDeathUpProtection", 5);
		RESPAWN_RESTORE_HP = players.getProperty("RespawnRestoreHP", 0.7);
		MAX_PVTSTORE_SLOTS_DWARF = players.getProperty("MaxPvtStoreSlotsDwarf", 5);
		MAX_PVTSTORE_SLOTS_OTHER = players.getProperty("MaxPvtStoreSlotsOther", 4);
		DEEPBLUE_DROP_RULES = players.getProperty("UseDeepBlueDropRules", true);
		ALLOW_DELEVEL = players.getProperty("AllowDelevel", true);
		DEATH_PENALTY_CHANCE = players.getProperty("DeathPenaltyChance", 20);
		
		INVENTORY_MAXIMUM_NO_DWARF = players.getProperty("MaximumSlotsForNoDwarf", 80);
		INVENTORY_MAXIMUM_DWARF = players.getProperty("MaximumSlotsForDwarf", 100);
		INVENTORY_MAXIMUM_PET = players.getProperty("MaximumSlotsForPet", 12);
		MAX_ITEM_IN_PACKET = Math.max(INVENTORY_MAXIMUM_NO_DWARF, INVENTORY_MAXIMUM_DWARF);
		WEIGHT_LIMIT = players.getProperty("WeightLimit", 1.);
		WAREHOUSE_SLOTS_NO_DWARF = players.getProperty("MaximumWarehouseSlotsForNoDwarf", 100);
		WAREHOUSE_SLOTS_DWARF = players.getProperty("MaximumWarehouseSlotsForDwarf", 120);
		WAREHOUSE_SLOTS_CLAN = players.getProperty("MaximumWarehouseSlotsForClan", 150);
		FREIGHT_SLOTS = players.getProperty("MaximumFreightSlots", 20);
		REGION_BASED_FREIGHT = players.getProperty("RegionBasedFreight", true);
		FREIGHT_PRICE = players.getProperty("FreightPrice", 1000);
		
		ENCHANT_CHANCE_WEAPON = new HashMap<>();
		String[] property = players.getProperty("EnchantChanceWeapon", (String[]) null, ",");
		for (String data : property)
		{
			String[] enchant = data.split("-");
			ENCHANT_CHANCE_WEAPON.put(Integer.parseInt(enchant[0]), Double.parseDouble(enchant[1]));
		}
		ENCHANT_CHANCE_ARMOR = new HashMap<>();
		property = players.getProperty("EnchantChanceArmor", (String[]) null, ",");
		for (String data : property)
		{
			String[] enchant = data.split("-");
			ENCHANT_CHANCE_ARMOR.put(Integer.valueOf(Integer.parseInt(enchant[0])), Double.valueOf(Double.parseDouble(enchant[1])));
		}
		BLESSED_ENCHANT_CHANCE_WEAPON = new HashMap<>();
		property = players.getProperty("BlessedEnchantChanceWeapon", (String[]) null, ",");
		for (String data : property)
		{
			String[] enchant = data.split("-");
			BLESSED_ENCHANT_CHANCE_WEAPON.put(Integer.valueOf(Integer.parseInt(enchant[0])), Double.valueOf(Double.parseDouble(enchant[1])));
		}
		BLESSED_ENCHANT_CHANCE_ARMOR = new HashMap<>();
		property = players.getProperty("BlessedEnchantChanceArmor", (String[]) null, ",");
		for (String data : property)
		{
			String[] enchant = data.split("-");
			BLESSED_ENCHANT_CHANCE_ARMOR.put(Integer.valueOf(Integer.parseInt(enchant[0])), Double.valueOf(Double.parseDouble(enchant[1])));
		}
		CRYSTAL_ENCHANT_CHANCE_WEAPON = new HashMap<>();
		property = players.getProperty("CrystalEnchantChanceWeapon", (String[]) null, ",");
		for (String data : property)
		{
			String[] enchant = data.split("-");
			CRYSTAL_ENCHANT_CHANCE_WEAPON.put(Integer.valueOf(Integer.parseInt(enchant[0])), Double.valueOf(Double.parseDouble(enchant[1])));
		}
		CRYSTAL_ENCHANT_CHANCE_ARMOR = new HashMap<>();
		property = players.getProperty("CrystalEnchantChanceArmor", (String[]) null, ",");
		for (String data : property)
		{
			String[] enchant = data.split("-");
			CRYSTAL_ENCHANT_CHANCE_ARMOR.put(Integer.valueOf(Integer.parseInt(enchant[0])), Double.valueOf(Double.parseDouble(enchant[1])));
		}
		ENCHANT_MAX_WEAPON = players.getProperty("EnchantMaxWeapon", 0);
		ENCHANT_MAX_ARMOR = players.getProperty("EnchantMaxArmor", 0);
		ENCHANT_SAFE_MAX = players.getProperty("EnchantSafeMax", 3);
		ENCHANT_SAFE_MAX_FULL = players.getProperty("EnchantSafeMaxFull", 4);
		ENCHANT_FAILED_VALUE = players.getProperty("EnchantFailedValue", 0);
		
		AUGMENTATION_NG_SKILL_CHANCE = players.getProperty("AugmentationNGSkillChance", 15);
		AUGMENTATION_NG_GLOW_CHANCE = players.getProperty("AugmentationNGGlowChance", 0);
		AUGMENTATION_MID_SKILL_CHANCE = players.getProperty("AugmentationMidSkillChance", 30);
		AUGMENTATION_MID_GLOW_CHANCE = players.getProperty("AugmentationMidGlowChance", 40);
		AUGMENTATION_HIGH_SKILL_CHANCE = players.getProperty("AugmentationHighSkillChance", 45);
		AUGMENTATION_HIGH_GLOW_CHANCE = players.getProperty("AugmentationHighGlowChance", 70);
		AUGMENTATION_TOP_SKILL_CHANCE = players.getProperty("AugmentationTopSkillChance", 60);
		AUGMENTATION_TOP_GLOW_CHANCE = players.getProperty("AugmentationTopGlowChance", 100);
		AUGMENTATION_BASESTAT_CHANCE = players.getProperty("AugmentationBaseStatChance", 1);
		
		KARMA_PLAYER_CAN_SHOP = players.getProperty("KarmaPlayerCanShop", false);
		KARMA_PLAYER_CAN_USE_GK = players.getProperty("KarmaPlayerCanUseGK", false);
		KARMA_PLAYER_CAN_TELEPORT = players.getProperty("KarmaPlayerCanTeleport", true);
		KARMA_PLAYER_CAN_TRADE = players.getProperty("KarmaPlayerCanTrade", true);
		KARMA_PLAYER_CAN_USE_WH = players.getProperty("KarmaPlayerCanUseWareHouse", true);
		KARMA_DROP_GM = players.getProperty("CanGMDropEquipment", false);
		KARMA_AWARD_PK_KILL = players.getProperty("AwardPKKillPVPPoint", true);
		KARMA_PK_LIMIT = players.getProperty("MinimumPKRequiredToDrop", 5);
		KARMA_NONDROPPABLE_PET_ITEMS = players.getProperty("ListOfPetItems", new int[]
		{
			2375,
			3500,
			3501,
			3502,
			4422,
			4423,
			4424,
			4425,
			6648,
			6649,
			6650
		});
		KARMA_NONDROPPABLE_ITEMS = players.getProperty("ListOfNonDroppableItemsForPK", new int[]
		{
			1147,
			425,
			1146,
			461,
			10,
			2368,
			7,
			6,
			2370,
			2369
		});
		
		PVP_NORMAL_TIME = players.getProperty("PvPVsNormalTime", 40000);
		PVP_PVP_TIME = players.getProperty("PvPVsPvPTime", 20000);
		
		PARTY_XP_CUTOFF_METHOD = players.getProperty("PartyXpCutoffMethod", "level");
		PARTY_XP_CUTOFF_PERCENT = players.getProperty("PartyXpCutoffPercent", 3.);
		PARTY_XP_CUTOFF_LEVEL = players.getProperty("PartyXpCutoffLevel", 20);
		PARTY_RANGE = players.getProperty("PartyRange", 1500);
		
		DEFAULT_ACCESS_LEVEL = players.getProperty("DefaultAccessLevel", 0);
		GM_HERO_AURA = players.getProperty("GMHeroAura", false);
		GM_STARTUP_INVULNERABLE = players.getProperty("GMStartupInvulnerable", false);
		GM_STARTUP_INVISIBLE = players.getProperty("GMStartupInvisible", false);
		GM_STARTUP_BLOCK_ALL = players.getProperty("GMStartupBlockAll", false);
		GM_STARTUP_AUTO_LIST = players.getProperty("GMStartupAutoList", true);
		
		PETITIONING_ALLOWED = players.getProperty("PetitioningAllowed", true);
		MAX_PETITIONS_PER_PLAYER = players.getProperty("MaxPetitionsPerPlayer", 5);
		MAX_PETITIONS_PENDING = players.getProperty("MaxPetitionsPending", 25);
		
		IS_CRAFTING_ENABLED = players.getProperty("CraftingEnabled", true);
		DWARF_RECIPE_LIMIT = players.getProperty("DwarfRecipeLimit", 50);
		COMMON_RECIPE_LIMIT = players.getProperty("CommonRecipeLimit", 50);
		BLACKSMITH_USE_RECIPES = players.getProperty("BlacksmithUseRecipes", true);
		
		AUTO_LEARN_SKILLS = players.getProperty("AutoLearnSkills", false);
		LVL_AUTO_LEARN_SKILLS = players.getProperty("LvlAutoLearnSkills", 40);
		MAGIC_FAILURES = players.getProperty("MagicFailures", true);
		PERFECT_SHIELD_BLOCK_RATE = players.getProperty("PerfectShieldBlockRate", 5);
		LIFE_CRYSTAL_NEEDED = players.getProperty("LifeCrystalNeeded", true);
		SP_BOOK_NEEDED = players.getProperty("SpBookNeeded", true);
		ES_SP_BOOK_NEEDED = players.getProperty("EnchantSkillSpBookNeeded", true);
		DIVINE_SP_BOOK_NEEDED = players.getProperty("DivineInspirationSpBookNeeded", true);
		SUBCLASS_WITHOUT_QUESTS = players.getProperty("SubClassWithoutQuests", false);
		
		MAX_BUFFS_AMOUNT = players.getProperty("MaxBuffsAmount", 20);
		STORE_SKILL_COOLTIME = players.getProperty("StoreSkillCooltime", true);
	}
	
	/**
	 * Loads siege settings.
	 */
	private static final void loadSieges()
	{
		final ExProperties sieges = initProperties(Config.SIEGE_FILE);
		
		SIEGE_LENGTH = sieges.getProperty("SiegeLength", 120);
		MINIMUM_CLAN_LEVEL = sieges.getProperty("SiegeClanMinLevel", 4);
		MAX_ATTACKERS_NUMBER = sieges.getProperty("AttackerMaxClans", 10);
		MAX_DEFENDERS_NUMBER = sieges.getProperty("DefenderMaxClans", 10);
		ATTACKERS_RESPAWN_DELAY = sieges.getProperty("AttackerRespawn", 10000);
		
		CH_MINIMUM_CLAN_LEVEL = sieges.getProperty("ChSiegeClanMinLevel", 4);
		CH_MAX_ATTACKERS_NUMBER = sieges.getProperty("ChAttackerMaxClans", 10);
	}
	
	/**
	 * Loads gameserver settings.<br>
	 * IP addresses, database, rates, feature enabled/disabled, misc.
	 */
	private static final void loadServer()
	{
		final ExProperties server = initProperties(SERVER_FILE);
		
		HOSTNAME = server.getProperty("Hostname", "*");
		GAMESERVER_HOSTNAME = server.getProperty("GameserverHostname");
		GAMESERVER_PORT = server.getProperty("GameserverPort", 7777);
		GAMESERVER_LOGIN_HOSTNAME = server.getProperty("LoginHost", "127.0.0.1");
		GAMESERVER_LOGIN_PORT = server.getProperty("LoginPort", 9014);
		REQUEST_ID = server.getProperty("RequestServerID", 0);
		ACCEPT_ALTERNATE_ID = server.getProperty("AcceptAlternateID", true);
		USE_BLOWFISH_CIPHER = server.getProperty("UseBlowfishCipher", true);
		
		DATABASE_URL = server.getProperty("URL", "jdbc:mariadb://localhost/acis");
		DATABASE_LOGIN = server.getProperty("Login", "root");
		DATABASE_PASSWORD = server.getProperty("Password", "");
		DATABASE_MAX_CONNECTIONS = server.getProperty("MaximumDbConnections", 10);
		
		CNAME_TEMPLATE = server.getProperty("CnameTemplate", ".*");
		TITLE_TEMPLATE = server.getProperty("TitleTemplate", ".*");
		PET_NAME_TEMPLATE = server.getProperty("PetNameTemplate", ".*");
		
		SERVER_LIST_BRACKET = server.getProperty("ServerListBrackets", false);
		SERVER_LIST_CLOCK = server.getProperty("ServerListClock", false);
		SERVER_GMONLY = server.getProperty("ServerGMOnly", false);
		SERVER_LIST_AGE = server.getProperty("ServerListAgeLimit", 0);
		SERVER_LIST_TESTSERVER = server.getProperty("TestServer", false);
		SERVER_LIST_PVPSERVER = server.getProperty("PvpServer", true);
		
		DELETE_DAYS = server.getProperty("DeleteCharAfterDays", 7);
		MAXIMUM_ONLINE_USERS = server.getProperty("MaximumOnlineUsers", 100);
		
		AUTO_LOOT = server.getProperty("AutoLoot", false);
		AUTO_LOOT_HERBS = server.getProperty("AutoLootHerbs", false);
		AUTO_LOOT_RAID = server.getProperty("AutoLootRaid", false);
		
		ALLOW_DISCARDITEM = server.getProperty("AllowDiscardItem", true);
		MULTIPLE_ITEM_DROP = server.getProperty("MultipleItemDrop", true);
		HERB_AUTO_DESTROY_TIME = server.getProperty("AutoDestroyHerbTime", 15) * 1000;
		ITEM_AUTO_DESTROY_TIME = server.getProperty("AutoDestroyItemTime", 600) * 1000;
		EQUIPABLE_ITEM_AUTO_DESTROY_TIME = server.getProperty("AutoDestroyEquipableItemTime", 0) * 1000;
		SPECIAL_ITEM_DESTROY_TIME = new HashMap<>();
		String[] data = server.getProperty("AutoDestroySpecialItemTime", (String[]) null, ",");
		if (data != null)
		{
			for (String itemData : data)
			{
				String[] item = itemData.split("-");
				SPECIAL_ITEM_DESTROY_TIME.put(Integer.parseInt(item[0]), Integer.parseInt(item[1]) * 1000);
			}
		}
		PLAYER_DROPPED_ITEM_MULTIPLIER = server.getProperty("PlayerDroppedItemMultiplier", 1);
		
		ALLOW_FREIGHT = server.getProperty("AllowFreight", true);
		ALLOW_WAREHOUSE = server.getProperty("AllowWarehouse", true);
		ALLOW_WEAR = server.getProperty("AllowWear", true);
		WEAR_DELAY = server.getProperty("WearDelay", 5);
		WEAR_PRICE = server.getProperty("WearPrice", 10);
		ALLOW_LOTTERY = server.getProperty("AllowLottery", true);
		ALLOW_WATER = server.getProperty("AllowWater", true);
		ALLOW_MANOR = server.getProperty("AllowManor", true);
		ALLOW_BOAT = server.getProperty("AllowBoat", true);
		ALLOW_CURSED_WEAPONS = server.getProperty("AllowCursedWeapons", true);
		
		ENABLE_FALLING_DAMAGE = server.getProperty("EnableFallingDamage", true);
		
		NO_SPAWNS = server.getProperty("NoSpawns", false);
		DEVELOPER = server.getProperty("Developer", false);
		PACKET_HANDLER_DEBUG = server.getProperty("PacketHandlerDebug", false);
		
		DEADLOCK_DETECTOR = server.getProperty("DeadLockDetector", false);
		DEADLOCK_CHECK_INTERVAL = server.getProperty("DeadLockCheckInterval", 20);
		RESTART_ON_DEADLOCK = server.getProperty("RestartOnDeadlock", false);
		
		LOG_CHAT = server.getProperty("LogChat", false);
		LOG_ITEMS = server.getProperty("LogItems", false);
		GMAUDIT = server.getProperty("GMAudit", false);
		
		ENABLE_COMMUNITY_BOARD = server.getProperty("EnableCommunityBoard", false);
		BBS_DEFAULT = server.getProperty("BBSDefault", "_bbshome");
		
		ROLL_DICE_TIME = server.getProperty("RollDiceTime", 4200);
		HERO_VOICE_TIME = server.getProperty("HeroVoiceTime", 10000);
		SUBCLASS_TIME = server.getProperty("SubclassTime", 2000);
		DROP_ITEM_TIME = server.getProperty("DropItemTime", 1000);
		SERVER_BYPASS_TIME = server.getProperty("ServerBypassTime", 100);
		MULTISELL_TIME = server.getProperty("MultisellTime", 100);
		MANUFACTURE_TIME = server.getProperty("ManufactureTime", 300);
		MANOR_TIME = server.getProperty("ManorTime", 3000);
		SENDMAIL_TIME = server.getProperty("SendMailTime", 10000);
		CHARACTER_SELECT_TIME = server.getProperty("CharacterSelectTime", 3000);
		GLOBAL_CHAT_TIME = server.getProperty("GlobalChatTime", 0);
		TRADE_CHAT_TIME = server.getProperty("TradeChatTime", 0);
		SOCIAL_TIME = server.getProperty("SocialTime", 2000);
		ITEM_TIME = server.getProperty("ItemTime", 100);
		ACTION_TIME = server.getProperty("ActionTime", 2000);
		
		SCHEDULED_THREAD_POOL_COUNT = server.getProperty("ScheduledThreadPoolCount", -1);
		THREADS_PER_SCHEDULED_THREAD_POOL = server.getProperty("ThreadsPerScheduledThreadPool", 4);
		INSTANT_THREAD_POOL_COUNT = server.getProperty("InstantThreadPoolCount", -1);
		THREADS_PER_INSTANT_THREAD_POOL = server.getProperty("ThreadsPerInstantThreadPool", 2);
		
		L2WALKER_PROTECTION = server.getProperty("L2WalkerProtection", false);
		ZONE_TOWN = server.getProperty("ZoneTown", 0);
		SERVER_NEWS = server.getProperty("ShowServerNews", false);
	}
	
	private static final void loadRates()
	{
		final ExProperties rates = initProperties(RATES_FILE);
		RATE_XP = rates.getProperty("RateXp", 1.);
		RATE_SP = rates.getProperty("RateSp", 1.);
		RATE_PARTY_XP = rates.getProperty("RatePartyXp", 1.);
		RATE_PARTY_SP = rates.getProperty("RatePartySp", 1.);
		RATE_DROP_CURRENCY = rates.getProperty("RateDropCurency", 1.);
		RATE_DROP_ITEMS = rates.getProperty("RateDropItems", 1.);
		RATE_DROP_ITEMS_BY_RAID = rates.getProperty("RateRaidDropItems", 1.);
		RATE_DROP_ITEMS_BY_GRAND = rates.getProperty("RateGrandDropItems", 1.);
		RATE_DROP_SPOIL = rates.getProperty("RateDropSpoil", 1.);
		
		PREMIUM_RATE_XP = rates.getProperty("PremiumRateXp", 2.);
		PREMIUM_RATE_SP = rates.getProperty("PremiumRateSp", 2.);
		PREMIUM_RATE_DROP_CURRENCY = rates.getProperty("PremiumRateDropCurency", 2.);
		PREMIUM_RATE_DROP_SPOIL = rates.getProperty("PremiumRateDropSpoil", 2.);
		PREMIUM_RATE_DROP_ITEMS = rates.getProperty("PremiumRateDropItems", 2.);
		PREMIUM_RATE_DROP_ITEMS_BY_RAID = rates.getProperty("PremiumRateRaidDropItems", 2.);
		PREMIUM_RATE_DROP_ITEMS_BY_GRAND = rates.getProperty("PremiumRateGrandDropItems", 2.);
		
		PREMIUM_RATE_QUEST_DROP = rates.getProperty("PremiumRateQuestDrop", 2.);
		PREMIUM_RATE_QUEST_REWARD = rates.getProperty("PremiumRateQuestReward", 2.);
		PREMIUM_RATE_QUEST_REWARD_XP = rates.getProperty("PremiumRateQuestRewardXP", 2.);
		PREMIUM_RATE_QUEST_REWARD_SP = rates.getProperty("PremiumRateQuestRewardSP", 2.);
		PREMIUM_RATE_QUEST_REWARD_ADENA = rates.getProperty("PremiumRateQuestRewardAdena", 2.);
		
		RATE_DROP_HERBS = rates.getProperty("RateDropHerbs", 1.);
		RATE_DROP_MANOR = rates.getProperty("RateDropManor", 1);
		RATE_QUEST_DROP = rates.getProperty("RateQuestDrop", 1.);
		RATE_QUEST_REWARD = rates.getProperty("RateQuestReward", 1.);
		RATE_QUEST_REWARD_XP = rates.getProperty("RateQuestRewardXP", 1.);
		RATE_QUEST_REWARD_SP = rates.getProperty("RateQuestRewardSP", 1.);
		RATE_QUEST_REWARD_ADENA = rates.getProperty("RateQuestRewardAdena", 1.);
		RATE_KARMA_EXP_LOST = rates.getProperty("RateKarmaExpLost", 1.);
		RATE_SIEGE_GUARDS_PRICE = rates.getProperty("RateSiegeGuardsPrice", 1.);
		PLAYER_DROP_LIMIT = rates.getProperty("PlayerDropLimit", 3);
		PLAYER_RATE_DROP = rates.getProperty("PlayerRateDrop", 5);
		PLAYER_RATE_DROP_ITEM = rates.getProperty("PlayerRateDropItem", 70);
		PLAYER_RATE_DROP_EQUIP = rates.getProperty("PlayerRateDropEquip", 25);
		PLAYER_RATE_DROP_EQUIP_WEAPON = rates.getProperty("PlayerRateDropEquipWeapon", 5);
		PET_XP_RATE = rates.getProperty("PetXpRate", 1.);
		PET_FOOD_RATE = rates.getProperty("PetFoodRate", 1);
		SINEATER_XP_RATE = rates.getProperty("SinEaterXpRate", 1.);
		KARMA_DROP_LIMIT = rates.getProperty("KarmaDropLimit", 10);
		KARMA_RATE_DROP = rates.getProperty("KarmaRateDrop", 70);
		KARMA_RATE_DROP_ITEM = rates.getProperty("KarmaRateDropItem", 50);
		KARMA_RATE_DROP_EQUIP = rates.getProperty("KarmaRateDropEquip", 40);
		KARMA_RATE_DROP_EQUIP_WEAPON = rates.getProperty("KarmaRateDropEquipWeapon", 10);
	}
	
	private static final void loadRusAcis()
	{
		final ExProperties rusacis = initProperties(RUS_ACIS_FILE);
		INFINITY_SS = rusacis.getProperty("InfinitySS", false);
		INFINITY_ARROWS = rusacis.getProperty("InfinityArrows", false);
		
		OLY_USE_CUSTOM_PERIOD_SETTINGS = rusacis.getProperty("OlyUseCustomPeriodSettings", false);
		OLY_PERIOD = OlympiadPeriod.valueOf(rusacis.getProperty("OlyPeriod", "MONTH"));
		OLY_PERIOD_MULTIPLIER = rusacis.getProperty("OlyPeriodMultiplier", 1);
		
		ENABLE_MODIFY_SKILL_DURATION = rusacis.getProperty("EnableModifySkillDuration", false);
		if (ENABLE_MODIFY_SKILL_DURATION)
		{
			SKILL_DURATION_LIST = new HashMap<>();
			String[] propertySplit = rusacis.getProperty("SkillDurationList", "").split(";");
			
			for (String skill : propertySplit)
			{
				String[] skillSplit = skill.split(",");
				if (skillSplit.length != 2)
					LOGGER.warn("[SkillDurationList]: invalid config property -> SkillDurationList \"" + skill + "\"");
				else
				{
					try
					{
						SKILL_DURATION_LIST.put(Integer.parseInt(skillSplit[0]), Integer.parseInt(skillSplit[1]));
					}
					catch (NumberFormatException nfe)
					{
						nfe.printStackTrace();
						
						if (!skill.equals(""))
							LOGGER.warn("[SkillDurationList]: invalid config property -> SkillList \"" + skillSplit[0] + "\"" + skillSplit[1]);
					}
				}
			}
		}
		
		GLOBAL_CHAT = rusacis.getProperty("GlobalChat", "ON");
		TRADE_CHAT = rusacis.getProperty("TradeChat", "ON");
		CHAT_ALL_LEVEL = rusacis.getProperty("AllChatLevel", 1);
		CHAT_TELL_LEVEL = rusacis.getProperty("TellChatLevel", 1);
		CHAT_SHOUT_LEVEL = rusacis.getProperty("ShoutChatLevel", 1);
		CHAT_TRADE_LEVEL = rusacis.getProperty("TradeChatLevel", 1);
		
		ENABLE_MENU = rusacis.getProperty("EnableMenu", false);
		ENABLE_ONLINE_COMMAND = rusacis.getProperty("EnabledOnlineCommand", false);
		
		BOTS_PREVENTION = rusacis.getProperty("EnableBotsPrevention", false);
		KILLS_COUNTER = rusacis.getProperty("KillsCounter", 60);
		KILLS_COUNTER_RANDOMIZATION = rusacis.getProperty("KillsCounterRandomization", 50);
		VALIDATION_TIME = rusacis.getProperty("ValidationTime", 60);
		PUNISHMENT = rusacis.getProperty("Punishment", 0);
		PUNISHMENT_TIME = rusacis.getProperty("PunishmentTime", 60);
		
		USE_PREMIUM_SERVICE = rusacis.getProperty("UsePremiumServices", false);
		ALTERNATE_DROP_LIST = rusacis.getProperty("AlternateDropList", false);
		ENABLE_SKIPPING = rusacis.getProperty("EnableSkippingItems", false);
		
		ATTACK_PTS = rusacis.getProperty("AttackPTS", true);
		SUBCLASS_SKILLS = rusacis.getProperty("SubClassSkills", false);
		GAME_SUBCLASS_EVERYWHERE = rusacis.getProperty("SubclassEverywhere", false);
		
		SHOW_NPC_INFO = rusacis.getProperty("ShowNpcInfo", false);
		ALLOW_GRAND_BOSSES_TELEPORT = rusacis.getProperty("AllowGrandBossesTeleport", false);
		
		USE_SAY_FILTER = rusacis.getProperty("UseChatFilter", false);
		CHAT_FILTER_CHARS = rusacis.getProperty("ChatFilterChars", "^_^");
		
		try
		{
			FILTER_LIST = Files.lines(Paths.get(CHAT_FILTER_FILE), StandardCharsets.UTF_8).map(String::trim).filter(line -> (!line.isEmpty() && (line.charAt(0) != '#'))).collect(Collectors.toList());
			LOGGER.info("Loaded " + FILTER_LIST.size() + " Filter Words.");
		}
		catch (IOException e)
		{
			LOGGER.warn("Error while loading chat filter words!", e);
		}
		
		CABAL_BUFFER = rusacis.getProperty("CabalBuffer", false);
		SUPER_HASTE = rusacis.getProperty("SuperHaste", false);
		
		RESTRICTED_CHAR_NAMES = rusacis.getProperty("ListOfRestrictedCharNames", "");
		LIST_RESTRICTED_CHAR_NAMES = new ArrayList<>();
		for (String name : RESTRICTED_CHAR_NAMES.split(","))
			LIST_RESTRICTED_CHAR_NAMES.add(name.toLowerCase());
		
		FAKE_ONLINE_AMOUNT = rusacis.getProperty("FakeOnlineAmount", 1);
		
		BUFFS_CATEGORY = rusacis.getProperty("PremiumBuffsCategory", "");
		PREMIUM_BUFFS_CATEGORY = new ArrayList<>();
		for (String buffs : BUFFS_CATEGORY.split(","))
			PREMIUM_BUFFS_CATEGORY.add(buffs);
		
		ANTIFEED_ENABLE = rusacis.getProperty("AntiFeedEnable", false);
		ANTIFEED_DUALBOX = rusacis.getProperty("AntiFeedDualbox", true);
		ANTIFEED_DISCONNECTED_AS_DUALBOX = rusacis.getProperty("AntiFeedDisconnectedAsDualbox", true);
		ANTIFEED_INTERVAL = rusacis.getProperty("AntiFeedInterval", 120) * 1000;
		
		DUALBOX_CHECK_MAX_PLAYERS_PER_IP = rusacis.getProperty("DualboxCheckMaxPlayersPerIP", 0);
		DUALBOX_CHECK_MAX_OLYMPIAD_PARTICIPANTS_PER_IP = rusacis.getProperty("DualboxCheckMaxOlympiadParticipantsPerIP", 0);
		String[] propertySplit = rusacis.getProperty("DualboxCheckWhitelist", "127.0.0.1,0").split(";");
		DUALBOX_CHECK_WHITELIST = new HashMap<>(propertySplit.length);
		for (String entry : propertySplit)
		{
			String[] entrySplit = entry.split(",");
			if (entrySplit.length != 2)
				LOGGER.warn("DualboxCheck[Config.load()]: invalid config property -> DualboxCheckWhitelist \"", entry, "\"");
			else
			{
				try
				{
					int num = Integer.parseInt(entrySplit[1]);
					num = num == 0 ? -1 : num;
					DUALBOX_CHECK_WHITELIST.put(InetAddress.getByName(entrySplit[0]).hashCode(), num);
				}
				catch (UnknownHostException e)
				{
					LOGGER.warn("DualboxCheck[Config.load()]: invalid address -> DualboxCheckWhitelist \"", entrySplit[0], "\"");
				}
				catch (NumberFormatException e)
				{
					LOGGER.warn("DualboxCheck[Config.load()]: invalid number -> DualboxCheckWhitelist \"", entrySplit[1], "\"");
				}
			}
		}
		
		String[] autoLootItemIds = rusacis.getProperty("AutoLootItemIds", "0").split(",");
		AUTO_LOOT_ITEM_IDS = new ArrayList<>(autoLootItemIds.length);
		for (String item : autoLootItemIds)
		{
			Integer itm = 0;
			try
			{
				itm = Integer.parseInt(item);
			}
			catch (NumberFormatException nfe)
			{
				LOGGER.warn("Auto loot item ids: Wrong ItemId passed: " + item);
			}
			
			if (itm != 0)
				AUTO_LOOT_ITEM_IDS.add(itm);
		}
	}
	
	/**
	 * Loads loginserver settings.<br>
	 * IP addresses, database, account, misc.
	 */
	private static final void loadLogin()
	{
		final ExProperties server = initProperties(LOGINSERVER_FILE);
		
		HOSTNAME = server.getProperty("Hostname", "localhost");
		LOGINSERVER_HOSTNAME = server.getProperty("LoginserverHostname", "*");
		LOGINSERVER_PORT = server.getProperty("LoginserverPort", 2106);
		GAMESERVER_LOGIN_HOSTNAME = server.getProperty("LoginHostname", "*");
		GAMESERVER_LOGIN_PORT = server.getProperty("LoginPort", 9014);
		LOGIN_TRY_BEFORE_BAN = server.getProperty("LoginTryBeforeBan", 3);
		LOGIN_BLOCK_AFTER_BAN = server.getProperty("LoginBlockAfterBan", 600);
		ACCEPT_NEW_GAMESERVER = server.getProperty("AcceptNewGameServer", false);
		SHOW_LICENCE = server.getProperty("ShowLicence", true);
		
		DATABASE_URL = server.getProperty("URL", "jdbc:mariadb://localhost/acis");
		DATABASE_LOGIN = server.getProperty("Login", "root");
		DATABASE_PASSWORD = server.getProperty("Password", "");
		DATABASE_MAX_CONNECTIONS = server.getProperty("MaximumDbConnections", 5);
		
		AUTO_CREATE_ACCOUNTS = server.getProperty("AutoCreateAccounts", true);
		
		FLOOD_PROTECTION = server.getProperty("EnableFloodProtection", true);
		FAST_CONNECTION_LIMIT = server.getProperty("FastConnectionLimit", 15);
		NORMAL_CONNECTION_TIME = server.getProperty("NormalConnectionTime", 700);
		FAST_CONNECTION_TIME = server.getProperty("FastConnectionTime", 350);
		MAX_CONNECTION_PER_IP = server.getProperty("MaxConnectionPerIP", 50);
	}
	
	public static final void loadGameServer()
	{
		LOGGER.info("Loading gameserver configuration files.");
		
		// offline settings
		loadOfflineShop();
		
		// clans settings
		loadClans();
		
		// events settings
		loadEvents();
		
		// geoengine settings
		loadGeoengine();
		
		// hexID
		loadHexID();
		
		// NPCs/monsters settings
		loadNpcs();
		
		// players settings
		loadPlayers();
		
		// siege settings
		loadSieges();
		
		// server settings
		loadServer();
		
		// rates settings
		loadRates();
		
		// rusacis settings
		loadRusAcis();
	}
	
	public static final void loadLoginServer()
	{
		LOGGER.info("Loading loginserver configuration files.");
		
		// login settings
		loadLogin();
	}
	
	public static final void loadAccountManager()
	{
		LOGGER.info("Loading account manager configuration files.");
		
		// login settings
		loadLogin();
	}
	
	public static final void loadGameServerRegistration()
	{
		LOGGER.info("Loading gameserver registration configuration files.");
		
		// login settings
		loadLogin();
	}
	
	public static final class ClassMasterSettings
	{
		private final Map<Integer, Boolean> _allowedClassChange;
		private final Map<Integer, List<IntIntHolder>> _claimItems;
		private final Map<Integer, List<IntIntHolder>> _rewardItems;
		
		public ClassMasterSettings(String configLine)
		{
			_allowedClassChange = new HashMap<>(3);
			_claimItems = new HashMap<>(3);
			_rewardItems = new HashMap<>(3);
			
			if (configLine != null)
				parseConfigLine(configLine.trim());
		}
		
		private void parseConfigLine(String configLine)
		{
			StringTokenizer st = new StringTokenizer(configLine, ";");
			while (st.hasMoreTokens())
			{
				// Get allowed class change.
				int job = Integer.parseInt(st.nextToken());
				
				_allowedClassChange.put(job, true);
				
				List<IntIntHolder> items = new ArrayList<>();
				
				// Parse items needed for class change.
				if (st.hasMoreTokens())
				{
					StringTokenizer st2 = new StringTokenizer(st.nextToken(), "[],");
					while (st2.hasMoreTokens())
					{
						StringTokenizer st3 = new StringTokenizer(st2.nextToken(), "()");
						items.add(new IntIntHolder(Integer.parseInt(st3.nextToken()), Integer.parseInt(st3.nextToken())));
					}
				}
				
				// Feed the map, and clean the list.
				_claimItems.put(job, items);
				items = new ArrayList<>();
				
				// Parse gifts after class change.
				if (st.hasMoreTokens())
				{
					StringTokenizer st2 = new StringTokenizer(st.nextToken(), "[],");
					while (st2.hasMoreTokens())
					{
						StringTokenizer st3 = new StringTokenizer(st2.nextToken(), "()");
						items.add(new IntIntHolder(Integer.parseInt(st3.nextToken()), Integer.parseInt(st3.nextToken())));
					}
				}
				
				_rewardItems.put(job, items);
			}
		}
		
		public boolean isAllowed(int job)
		{
			if (_allowedClassChange == null)
				return false;
			
			if (_allowedClassChange.containsKey(job))
				return _allowedClassChange.get(job);
			
			return false;
		}
		
		public List<IntIntHolder> getRewardItems(int job)
		{
			return _rewardItems.get(job);
		}
		
		public List<IntIntHolder> getRequiredItems(int job)
		{
			return _claimItems.get(job);
		}
	}
}