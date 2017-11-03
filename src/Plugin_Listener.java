import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class Plugin_Listener implements Listener {

    @EventHandler
    public void onEntityDeathEvent(EntityDeathEvent event){

        if (!(event.getEntity() instanceof Player)) {

            for (ItemStack i : event.getDrops()) {

                switch (i.getType()){
                    // Limit food drops
                    case RAW_BEEF:
                    case RAW_CHICKEN:
                    case MUTTON:
                    case PORK:
                        if (!Utils.random(0.5)) i.setType(Material.AIR);
                        break;
                    // Limit Web dropped by killed spiders
                    case WEB:
                        if (!Utils.random(0.3)) i.setType(Material.AIR);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
