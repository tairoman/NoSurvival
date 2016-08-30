import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;


public class Plugin_Listener implements Listener {

    @EventHandler
    public void onEntityDeathEvent(EntityDeathEvent event){

        double chance = 0.3;
        boolean willDrop;
        boolean isType;

        if (!(event.getEntity() instanceof Player)) {

            for (ItemStack i : event.getDrops()) {

                switch (i.getType()){
                    case RAW_BEEF:
                    case RAW_CHICKEN:
                    case PORK:
                        isType = true;  break;
                    default:
                        isType = false; break;
                }

                willDrop = Math.random() < chance;

                if (isType && willDrop) {
                    i.setType(Material.AIR);
                }
            }

            event.getDrops().clear();
        }
    }
}
