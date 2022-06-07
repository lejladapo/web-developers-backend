//package com.webdevelopersbackend.services;
//import com.webdevelopersbackend.data.ProfileInforTest;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Primary;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//@RunWith(SpringRunner.class)
//public class ProfileInforServiceTest {
//
//    @MockBean
//    private DevProfileRepository profileRepository;
//
//    @TestConfiguration
//    static class ItemServiceTestContextConfiguration {
//        @Bean
//        @Primary
//        public DevProfileService profileService(DevProfileRepository profileRepository) {
//            return new DevProfileService(profileRepository);
//        }
//    }
//    @Autowired
//    private DevProfileService profileService;
//
//    @Test
//    public void givenProfiles_whenGettingProfiles_thenProfilesShouldBeFound() {
//        Mockito.when(profileRepository.findAll())
//                .thenReturn(List.of(ProfileInforTest.profile()));
//
//        List<DevProfile> returnedList = profileService.getListDevProfile();
//
//        assertThat(returnedList).hasSize(1);
//    }
//
//    @Test
//    public void givenNoProfiles_whenGettingProfiles_thenListShouldBeEmpty() {
//        assertThat(profileService.getListDevProfile().isEmpty());
//    }
//
//    @Test
//    public void givenProfiles_whenGettingProfiles_thenRepositoryIsCalled() {
//        profileService.getListDevProfile();
//
//        verify(profileRepository, times(1)).findAll();
//    }
//
//    @Test
//    public void givenValidId_whenGettingOneProfile_thenProfileShouldBeFound() {
//        DevProfile profile = ProfileInforTest.profile();
//
//        Mockito.when(profileRepository.findById(profile.getId()))
//                .thenReturn(Optional.of(profile));
//
//        DevProfile resultList = profileService.getProfile(profile.getId());
//
//        assertThat(resultList.getName())
//                .isEqualTo(profile.getName());
//    }
//
//    @Test
//    public void givenInvalidId_whenGettingOneProfile_thenExceptionShouldBeThrown() {
//        assertThatThrownBy(() -> profileService.getProfile(14L))
//                .isInstanceOf(RuntimeException.class)
//                .hasMessageContaining("Id invalid.");
//    }
//
//    @Test
//    public void givenProfile_whenGettingOneProfile_thenProjectIsReturned() {
//        DevProfile input = ProfileInforTest.profile();
//        input.setId(0L);
//        DevProfile output = ProfileInforTest.profile();
//
//        Mockito.when(profileRepository.save(input))
//                .thenReturn(output);
//
//        DevProfile profile = profileService.addProfile(input);
//
//        assertThat(profile).isNotNull();
//        assertThat(profile.getName()).isEqualTo(input.getName());
//    }
//
//    @Test
//    public void givenProfile_whenDeletingProfile_thenRepositoryIsCalled() {
//        long id = ProfileInforTest.profile().getId();
//
//        profileService.deleteProfile(id);
//
//        verify(profileRepository, times(1)).deleteById(id);
//    }
//
//    @Test
//    public void givenProfile_whenAddingProfile_thenRepositoryIsCalled() {
//        DevProfile profile = ProfileInforTest.profile();
//
//        profileService.addProfile(profile);
//
//        verify(profileRepository, times(1)).save(profile);
//    }
//
//    @Test
//    public void givenProfile_whenAddingProfile_thenIdIsAssigned() {
//        DevProfile input = ProfileInforTest.profile();
//        input.setId(0L);
//        DevProfile output = ProfileInforTest.profile();
//
//        Mockito.when(profileRepository.save(input))
//                .thenReturn(output);
//
//        DevProfile result = profileService.addProfile(input);
//
//        assertThat(result.getId()).isNotEqualTo(0L);
//    }
//
//    @Test
//    public void givenProfileWithValidId_whenUpdatingProfile_thenProfileIsReturned() {
//        DevProfile input = ProfileInforTest.profile();
//        input.setId(0L);
//        long id = 2L;
//        DevProfile output = ProfileInforTest.profile();
//        output.setId(id);
//
//        Mockito.when(profileRepository.findById(id))
//                .thenReturn(Optional.of(output));
//        Mockito.when(profileRepository.save(input))
//                .thenReturn(output);
//
//        DevProfile resultItem = profileService.updateProfile(input, id);
//
//        assertThat(resultItem).isNotNull();
//        assertThat(resultItem.getName()).isEqualTo(input.getName());
//        assertThat(resultItem.getId()).isEqualTo(id);
//    }
//
//}
//
