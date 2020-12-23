import React, { useState, useEffect, useCallback } from 'react';
import api from '../../services/api';
import { Container, Form } from './styles';
import Input from '../../components/Input';
import Button from '../../components/Button';

export default function SingUp() {
  const [name, setName] = useState('');
  const [cpf, setCpf] = useState('');
  const [email, setEmail] = useState('');
  const [gender, setGender] = useState('');
  const [dateOfBirth, setDateOfBirth] = useState('');
  const [nacionality, setNacionality] = useState('');
  const [naturality, setNaturality] = useState('');

  useEffect(() => {
    api
      .get(`/users`, {
        auth: {
          username: 'admin',
          password: '123456',
        },
      })
      .then((response) => {
        console.log(response.data);
      });
  }, []);

  function handleSubmit(e) {
    e.preventDefault();

    const log = {
      name,
      cpf,
      gender,
      email,
      dateOfBirth,
      nacionality,
      naturality,
    };
    console.log(log);

    api
      .post(
        `/users`,
        {
          name,
          cpf,
          gender,
          email,
          dateOfBirth,
          nacionality,
          naturality,
        },
        {
          auth: {
            username: 'admin',
            password: '123456',
          },
        },
      )
      .then((response) => {
        console.log(response);
        alert('Successful registration');
      })
      .catch((error) => {
        console.log(error);
      });
  }

  return (
    <Container>
      <Form onSubmit={handleSubmit}>
        <p>Name *</p>
        <Input
          placeholder="John Doe"
          name="name"
          type="text"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <p>CPF *</p>
        <Input
          placeholder="999.999.999-99"
          name="cpf"
          type="text"
          value={cpf}
          onChange={(e) => setCpf(e.target.value)}
        />
        <p>Email</p>
        <Input
          placeholder="john@doe.com"
          name="email"
          type="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <p>Gender</p>
        <Input
          placeholder="Male/Female"
          name="gender"
          type="text"
          value={gender}
          onChange={(e) => setGender(e.target.value)}
        />
        <p>Date of birth *</p>
        <Input
          name="dateOfBirth"
          type="date"
          value={dateOfBirth}
          onChange={(e) => setDateOfBirth(e.target.value)}
        />
        <p>Nacionality</p>
        <Input
          placeholder="Brazil"
          name="nacionality"
          type="text"
          value={nacionality}
          onChange={(e) => setNacionality(e.target.value)}
        />
        <p>Naturality</p>
        <Input
          placeholder="Santa Catarina"
          name="naturality"
          type="text"
          value={naturality}
          onChange={(e) => setNaturality(e.target.value)}
        />

        <Button type="submit">Cadastrar</Button>
      </Form>
    </Container>
  );
}
