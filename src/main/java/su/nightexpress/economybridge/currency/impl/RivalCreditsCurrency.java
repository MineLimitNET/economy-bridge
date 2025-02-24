package su.nightexpress.economybridge.currency.impl;

import me.rivaldev.credits.api.RivalCreditsAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.economybridge.currency.type.AbstractCurrency;

import java.util.UUID;

public class RivalCreditsCurrency extends AbstractCurrency {

    private final RivalCreditsAPI api;

    public RivalCreditsCurrency(@NotNull String id) {
        super(id);
        api = new RivalCreditsAPI();
    }

    @Override
    public double getBalance(@NotNull Player player) {
        return api.getCredits(player);
    }

    @Override
    public double getBalance(@NotNull UUID playerId) {
        return api.getCredits(Bukkit.getOfflinePlayer(playerId));
    }

    @Override
    public void give(@NotNull Player player, double amount) {
        api.setCredits(player, getBalance(player) + amount);
    }

    @Override
    public void give(@NotNull UUID playerId, double amount) {
        final OfflinePlayer player = Bukkit.getOfflinePlayer(playerId);
        api.setCredits(player, getBalance(playerId) + amount);
    }

    @Override
    public void take(@NotNull Player player, double amount) {
        api.setCredits(player, getBalance(player) - amount);
    }

    @Override
    public void take(@NotNull UUID playerId, double amount) {
        final OfflinePlayer player = Bukkit.getOfflinePlayer(playerId);
        api.setCredits(player, getBalance(playerId) - amount);
    }

    @Override
    public boolean canHandleDecimals() {
        return true;
    }

    @Override
    public boolean canHandleOffline() {
        return true;
    }

    @Override
    public @NotNull String getDefaultName() {
        return "Rival Credits Currency";
    }

    @Override
    public @NotNull ItemStack getDefaultIcon() {
        return new ItemStack(Material.SUNFLOWER);
    }
}
