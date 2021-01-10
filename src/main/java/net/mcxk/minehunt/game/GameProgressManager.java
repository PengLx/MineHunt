package net.mcxk.minehunt.game;

import net.mcxk.minehunt.MineHunt;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 处理新的进度事件
 */
public class GameProgressManager {
    private final MineHunt plugin = MineHunt.getInstance();
    private final Set<GameProgress> unlocked = new HashSet<>();
    public void unlockProgress(GameProgress progress){
        if(plugin.getGame().getStatus() != GameStatus.GAME_STARTED){
            return;
        }
        if(!unlocked.add(progress)){
            return;
        }
        processProgress(progress);
    }
    private void processProgress(GameProgress progress){
        switch (progress){
            case NOT_STARTED:
            case GAME_STARTING:
            case STONE_AGE:
            case IRON_MINED:
                break;
            case COMPASS_UNLOCKED:
            case ENTER_NETHER:
                break;
            case GET_BLAZE_ROD:
                break;
            case GET_ENDER_PERAL:
                break;
            case ENTER_END:
                break;
            case KILLED_DRAGON:
                broadcastProgress(progress,false,false);
                break;
        }
    }
    private void broadcastProgress(GameProgress progress, boolean item, boolean buff){
        Bukkit.broadcastMessage(ChatColor.AQUA+"新的游戏阶段已解锁 "+ChatColor.GREEN+"["+progress.getDisplay()+"]");
        if(item){
            Bukkit.broadcastMessage(ChatColor.GREEN+"奖励补给已发放到您的背包中，请查收!");
        }
        if(buff){
            Bukkit.broadcastMessage(ChatColor.GREEN+"奖励药水效果以应用，请查看！");
        }
    }
}
