package net.minestorm.server.listener;

import net.minestorm.server.entity.Player;
import net.minestorm.server.network.packet.client.play.ClientStatusPacket;
import net.minestorm.server.network.packet.server.play.StatisticsPacket;
import net.minestorm.server.statistic.PlayerStatistic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StatusListener {

    public static void listener(ClientStatusPacket packet, Player player) {
        switch (packet.action) {
            case PERFORM_RESPAWN:
                player.respawn();
                break;
            case REQUEST_STATS:
                List<StatisticsPacket.Statistic> statisticList = new ArrayList<>();
                StatisticsPacket statisticsPacket = new StatisticsPacket();

                final Map<PlayerStatistic, Integer> playerStatisticValueMap = player.getStatisticValueMap();
                for (var entry : playerStatisticValueMap.entrySet()) {
                    final PlayerStatistic playerStatistic = entry.getKey();
                    final int value = entry.getValue();

                    StatisticsPacket.Statistic statistic = new StatisticsPacket.Statistic();
                    statistic.category = playerStatistic.getCategory();
                    statistic.statisticId = playerStatistic.getStatisticId();
                    statistic.value = value;

                    statisticList.add(statistic);
                }

                statisticsPacket.statistics = statisticList.toArray(new StatisticsPacket.Statistic[0]);

                player.getPlayerConnection().sendPacket(statisticsPacket);
                break;
        }
    }

}
