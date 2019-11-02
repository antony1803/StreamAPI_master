package by.courses.java.streamapi.operation;

import by.courses.java.streamapi.entity.UserBase;


import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultStream implements Operation<UserBase> {

    @Override
    public Collection<UserBase> removeWithMaxAge(Collection<UserBase> entities) {

        UserBase oneOfOldest = entities.stream().max(Comparator.comparing(UserBase::getAge)).get();
        return entities.stream().filter(temp->temp.getAge() < oneOfOldest.getAge()).collect(Collectors.toList());

    }

    @Override
    public Collection<UserBase> removeAllOlder(Collection<UserBase> entities, int age) {
        return entities.stream().filter(x -> x.getAge() <= age).collect(Collectors.toList());

    }

    @Override
    public double getAverageAge(Collection<UserBase> entities) {
        return entities.stream().mapToInt(temp -> temp.getAge()).average().getAsDouble();

    }

    @Override
    public UserBase getThirdInCollection(Collection<UserBase> entities) {
        return entities.stream().skip(2).findFirst().get();
    }

    @Override
    public Collection<UserBase> getTwoUsersStartingFromSecond(Collection<UserBase> entities) {
        return entities.stream().skip(1).limit(2).collect(Collectors.toList());
    }

    @Override
    public Collection<UserBase> getAllElementsByTemplate(Collection<UserBase> entities, UserBase userBase) {
        return entities.stream().filter(temp -> temp.equals(userBase)).collect(Collectors.toList());
    }

    @Override
    public boolean isCharacterPresentInAllNames(Collection<UserBase> entities, String character)
    {
        return entities.stream().allMatch((s) -> s.getName().toLowerCase().contains(character.toLowerCase()));

    }

    @Override
    public Collection<UserBase> addValueToAllNames(Collection<UserBase> entities, String value) {
        return entities.stream().map((s) -> UserBase.of(s.getName()+"_1", s.getAge())).collect(Collectors.toList());
    }

    @Override
    public Collection<UserBase> sortByNameThanByAge(Collection<UserBase> entities) {
        return entities.stream().sorted(Comparator.comparing(UserBase::getName).thenComparing(UserBase::getAge)).collect(Collectors.toList());
    }
}