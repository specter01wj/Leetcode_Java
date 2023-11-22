function minTrainingHours(initialEnergy, initialExperience, energy, experience) {
    var trainingHours = 0;
    var currentEnergy = initialEnergy;
    var currentExperience = initialExperience;
    for (var i = 0; i < energy.length; i++) {
        while (currentEnergy <= energy[i] || currentExperience <= experience[i]) {
            // Decide whether to increase energy or experience
            if (currentEnergy <= energy[i]) {
                currentEnergy++;
            }
            else {
                currentExperience++;
            }
            trainingHours++;
        }
        // Defeat the opponent
        currentEnergy -= energy[i];
        currentExperience += experience[i];
    }
    return trainingHours;
}
var initialEnergy = 5, initialExperience = 3, energy = [1, 4, 3, 2], experience = [2, 6, 3, 1];
var output = minTrainingHours(initialEnergy, initialExperience, energy, experience);
var webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();
