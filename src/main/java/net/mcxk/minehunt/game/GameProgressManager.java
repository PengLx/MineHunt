package net.mcxk.minehunt.game;

import net.mcxk.minehunt.MineHunt;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashSet;
import java.util.Set;

/**
 * 处理新的进度事件
 */
public class GameProgressManager {
    private final MineHunt plugin = MineHunt.getInstance();
    private final Set<GameProgress> unlocked = new HashSet<>();

    /**
     * 检查和解锁新的游戏进度
     *
     * @param progress 游戏进度
     */
    public void unlockProgress(GameProgress progress) {
        if (plugin.getGame().getStatus() != GameStatus.GAME_STARTED) {
            return;
        }
        if (!unlocked.add(progress)) {
            return;
        }
        processProgress(progress);
    }

    private void processProgress(GameProgress progress) {
        switch (progress) {
            case NOT_STARTED:
            case GAME_STARTING:
            case STONE_AGE:
            case IRON_MINED:
            case COMPASS_UNLOCKED:
            case ENTER_NETHER:
            case GET_BLAZE_ROD:
            case GET_ENDER_PERAL:
            case ENTER_END:
            case KILLED_DRAGON:
                broadcastProgress(progress);
                break;
        }
    }

    private void broadcastProgress(GameProgress progress) {
        Bukkit.broadcastMessage(ChatColor.AQUA + "新的游戏阶段已解锁 " + ChatColor.GREEN + "[" + progress.getDisplay() + "]");
    }
}
