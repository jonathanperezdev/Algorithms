import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

class CelebrityCollection {
    public Optional<TeamMember> findCelebrity(Map<TeamMember, Set<TeamMember>> teamKnows){

        TeamMember celebrity;
        Set<TeamMember> possibleCelebrities = findTeamMemberKnownAnybody(teamKnows);
        if(possibleCelebrities.isEmpty() || possibleCelebrities.size() > 1){
            return Optional.empty();
        }

        celebrity = possibleCelebrities.stream().findFirst().get();

        teamKnows.remove(celebrity);
        if(!isKnownByEverybody(celebrity, teamKnows)){
            celebrity = null;
        }

        return Optional.ofNullable(celebrity);
    }

    private Set<TeamMember> findTeamMemberKnownAnybody(Map<TeamMember, Set<TeamMember>> teamKnows){
        return teamKnows
                .entrySet()
                .stream()
                .filter(map -> map.getValue().isEmpty())
                .map(map -> map.getKey())
                .collect(Collectors.toSet());
    }

    private boolean isKnownByEverybody(TeamMember teamMember, Map<TeamMember, Set<TeamMember>> teamKnows){
        boolean isKnown = true;
        teamKnows.remove(teamMember);

        for(Set<TeamMember> teamMembersKnown : teamKnows.values()){
            if(!teamMembersKnown.contains(teamMember)){
                isKnown = false;
            }
        }

        return isKnown;
    }
}

class TeamMember {
    String name;

    public TeamMember(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamMember that = (TeamMember) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class CelebrityCollectionTest{
    private static Map<TeamMember, Set<TeamMember>> teamKnows = new HashMap<>();
    private static CelebrityCollection celebrityCollection = new CelebrityCollection();

    public static void main(String[] args){
        test1();
    }

    private  static Map<TeamMember, Set<TeamMember>> createTeamAndRelations(){

        TeamMember Jhon = new TeamMember("Jhon");
        TeamMember Luis = new TeamMember("Luis");
        TeamMember Javier = new TeamMember("Javier");
        TeamMember Camilo = new TeamMember("Camilo");

        teamKnows.put(Jhon, new HashSet<>());
        teamKnows.put(Luis, createSetOf( Jhon, Javier));
        teamKnows.put(Javier, createSetOf(Jhon, Camilo));
        teamKnows.put(Camilo, createSetOf(Jhon, Javier));

        return teamKnows;
    }

    private static HashSet<TeamMember> createSetOf(TeamMember ... teamMembers){
        return new HashSet<>(Arrays.asList(teamMembers));
    }

    @Test
    public static void test1(){
        Optional<TeamMember> optCelebrity = celebrityCollection.findCelebrity(createTeamAndRelations());
        optCelebrity.ifPresentOrElse(
                celeb -> System.out.println("Your celeb is "+ celeb.getName()),
                () -> System.out.println("No celebrity found"));
        assertTrue(optCelebrity.isPresent());
    }
}


