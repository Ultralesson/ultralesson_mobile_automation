package com.ultralesson.training.mobile.data.clients;

import com.ultralesson.training.mobile.models.User;

public class UserDataClient extends DataClient {

        public User getValidClient(String key) {
            String filePath = getFilePath("clients/valid_clients.json");
            return dataMapper.map(filePath, key, User.class);
        }
}
