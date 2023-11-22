
function minTrainingHours(initialEnergy: number, initialExperience: number, energy: number[], experience: number[]): number {
  let trainingHours: number = 0;
  let currentEnergy: number = initialEnergy;
  let currentExperience: number = initialExperience;

  for (let i = 0; i < energy.length; i++) {
      while (currentEnergy <= energy[i] || currentExperience <= experience[i]) {
          // Decide whether to increase energy or experience
          if (currentEnergy <= energy[i]) {
              currentEnergy++;
          } else {
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

let initialEnergy = 5, initialExperience = 3, energy = [1,4,3,2], experience = [2,6,3,1];
let output = minTrainingHours(initialEnergy, initialExperience, energy, experience);

let webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();


