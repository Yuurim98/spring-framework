const person = {
    name: "홍길동",
    address: {
        address: "서울시 송파구",
        details: "0000동 0000호",
    },
    profiles: ["twitter", "instagram", "facebook"],
    printProfile: () => {
        person.profiles.map((profile) => console.log(profile));
    },
};

export default function LearningJavaScript() {
    return (
        <>
            <div> {person.name} </div>
            <div> {person.address.address} </div>
            <div> {person.address.details} </div>
            <div> {person.profiles[0]} </div>
            <div> {person.printProfile()} </div>
        </>
    );
}
