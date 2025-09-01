package com.hexa;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService
{

    private final Map<Long , User> users = new HashMap<>();

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final String FILE_PATH = "src/main/resources/users.json";

    public UserService() throws Exception
    {
        loadUsersFromFile();
    }

    private void loadUsersFromFile() throws Exception
    {

        File file = new File(FILE_PATH);

        if(file.exists())
        {

            List<User> userList = objectMapper.readValue(file, new TypeReference<List<User>>() {});

            userList.forEach(user -> users.put(user.getId(), user));

        }

    }

    private void saveUsersToFile() throws Exception
    {

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH) , users.values());

    }

    public List<User> getAllUsers()
    {

        return new ArrayList<>(users.values());

    }

    public User getUserById(Long id)
    {

        return users.get(id);

    }


    public User addUser(User user) throws Exception
    {

        long newId = users.keySet().stream().mapToLong(Long::longValue).max().orElse(0) + 1;

        user.setId(newId);

        users.put(newId , user);

        saveUsersToFile();

        return user;

    }

    public User updateUser(Long id , User updateUser) throws Exception
    {

        if(users.containsKey(id))
        {
            updateUser.setId(id);

            users.put(id , updateUser);

            saveUsersToFile();

            return updateUser;
        }

        return null;

    }

    public boolean deleteUser(Long id) throws Exception
    {

        if(users.containsKey(id))
        {
            users.remove(id);

            saveUsersToFile();

            return true;

        }

        return false;


    }


}
