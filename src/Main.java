import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(new Plugin_Listener(), this);
    }

    @Override
    public void onDisable(){

    }
}
